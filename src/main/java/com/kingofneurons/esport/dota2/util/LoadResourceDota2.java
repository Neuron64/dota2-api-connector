package com.kingofneurons.esport.dota2.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LoadResourceDota2 implements Runnable{

    public static final int ID_DOWNLOAD_MINMAP = 1;
    public static final int ID_DOWNLOAD_ITEMS_IMAGE = 2;
    public static final int ID_DOWNLOAD_HERO_IMAGE = 3;
    public static final int ID_DOWNLOAD_ABILITIES_IMAGE = 4;

    final String FOLDER_LARGE = "/large/";
    final String FOLDER_SMALL = "/small/";
    final String FOLDER_MEDIUM = "/medium/";
    final String FOLDER_VERT = "/vert/";

    final String SUFFIX_SB_DOTA = "sb.png";
    final String SUFFIX_LG_DOTA = "lg.png";
    final String SUFFIX_FULL_DOTA = "full.png";
    final String SUFFIX_VERT_DOTA = "vert.jpg";

    final String path;
    final int idDownload;

    public static Logger logger = Logger.getLogger(LoadResourceDota2.class.getName());

    public LoadResourceDota2(int id, String path)
    {
        this.path = path;
        this.idDownload = id;
    }


    @Override
    public void run() {
        if(path == null){
            logger.log(Level.INFO, "you do not write path!");
            return;
        }
        try {
            switch (idDownload) {
                case ID_DOWNLOAD_MINMAP: startDownloadMinmapIconHero(); break;
                case ID_DOWNLOAD_ITEMS_IMAGE: startDownloadImageItemsDota2(); break;
                case ID_DOWNLOAD_ABILITIES_IMAGE: startDownloadAbilitiesDota2(); break;
                case ID_DOWNLOAD_HERO_IMAGE: startDownloadImageHeroDota2(); break;
                default: logger.log(Level.INFO, "you do not select id!");
                    break;
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "download finish!", e);
        }
        logger.log(Level.INFO, "download finish!");
    }

    public void startDownloadMinmapIconHero() throws MalformedURLException, IOException{
        final String URL_WIKI_WITCH_ICON = "http://dota2.gamepedia.com/Category:Hero_minimap_icons";
//    	final String URL_PATCH_MINMAP_HERO_ICON = "D:\\Esport Workspace\\Images\\IconHeroMinMap\\";

        Document doc = Jsoup.connect(URL_WIKI_WITCH_ICON)
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();

        Element content = doc.getElementById("content");
        Elements links = content.getElementsByTag("img");
        int i = 0;
        for (Element link : links) {
            String linkHref = link.attr("src");
            if(linkHref.substring(0, 53).equals("https://hydra-media.cursecdn.com/dota2.gamepedia.com/")){
                saveImage(new URL(linkHref), path + i + ".png");
                i++;
            }
        }
    }

    public void startDownloadAbilitiesDota2() throws MalformedURLException, IOException{
        final String URL_LIST_ID_ABILITIES = "https://raw.githubusercontent.com/kronusme/dota2-api/master/data/abilities.json";
        final String URL_IMAGE_ABILITIES = "http://cdn.dota2.com/apps/dota2/images/abilities/";
//    	final String URL_PATCH_ABILITIES = "/home/neuron/Изображения/AbilitiesDota2Image/";

        JsonArray jsonArray = downloadJSONPage(URL_LIST_ID_ABILITIES).getAsJsonArray("abilities");

        List<ImageDota2> listAbilities = new ArrayList<ImageDota2>();

        for(JsonElement element : jsonArray){
            JsonObject jsonItems = element.getAsJsonObject();
            ImageDota2 abiliti = new ImageDota2();

            abiliti.name = jsonItems.has("name")? jsonItems.get("name").getAsString() : null;
            abiliti.id = jsonItems.has("id")? jsonItems.get("id").getAsInt() : null;

            listAbilities.add(abiliti);
        }

        for(ImageDota2 abiliti : listAbilities){
            URL url = new URL(URL_IMAGE_ABILITIES + abiliti.name + "_" + "hp2.png");
            try{
                saveImage(url, path + "dota2_abiliti_" + abiliti.id + ".png");
            } catch(FileNotFoundException e){
                logger.log(Level.INFO, "File not Found", e);
            }
        }

    }

    public void startDownloadImageItemsDota2() throws MalformedURLException, IOException{
        final String URL_LIST_ID_ITEMS = "https://api.steampowered.com/IEconDOTA2_570/GetGameItems/V001/?key=4B1BE6B76C2B63E978962E2B38EC219E";
        final String URL_IMAGE_ITEMS = "http://cdn.dota2.com/apps/dota2/images/items/";
//    	final String URL_PATCH_ITEMS = "/home/neuron/Изображения/ItemsDota2Image/";

        JsonArray jsonArray = downloadJSONPage(URL_LIST_ID_ITEMS).getAsJsonObject("result").getAsJsonArray("items");

        List<ImageDota2> listItems = new ArrayList<ImageDota2>();

        for(JsonElement element : jsonArray){
            JsonObject jsonItems = element.getAsJsonObject();
            ImageDota2 item = new ImageDota2();

            item.name = jsonItems.has("name")? jsonItems.get("name").getAsString().replace("item_recipe_", "").replace("item_", "") : null;
            item.id = jsonItems.has("id")? jsonItems.get("id").getAsInt() : null;

            listItems.add(item);
        }

        for(ImageDota2 item : listItems){
            URL url = new URL(URL_IMAGE_ITEMS + item.name + "_" + "lg.png");
            try{
                saveImage(url, path + "dota2_item_" + item.id + ".png");
            } catch(FileNotFoundException e){
                logger.log(Level.INFO, "File not Found", e);
            }
        }

    }


    public void startDownloadImageHeroDota2() throws MalformedURLException, IOException{

        final String URL_LIST_ID_DOTA = "https://api.steampowered.com/IEconDOTA2_570/GetHeroes/v0001/?key=4B1BE6B76C2B63E978962E2B38EC219E&language=en_us";
        final String URL_IMAGE_DOTA = "http://cdn.dota2.com/apps/dota2/images/heroes/";
//    	final String URL_PATCH_HERO = "/home/neuron/Изображения/HeroDota2Image";

        final String[] MASS_SUFFIX = {SUFFIX_SB_DOTA, SUFFIX_LG_DOTA, SUFFIX_FULL_DOTA, SUFFIX_VERT_DOTA};


        JsonArray jsonArray = downloadJSONPage(URL_LIST_ID_DOTA).getAsJsonObject("result").getAsJsonArray("heroes");

        List<ImageDota2> listHero = new ArrayList<ImageDota2>();

        for(JsonElement element : jsonArray){
            JsonObject jsonHero = element.getAsJsonObject();
            ImageDota2 hero = new ImageDota2();

            hero.name = jsonHero.has("name")? jsonHero.get("name").getAsString().replace("npc_dota_hero_", "") : null;
            hero.id = jsonHero.has("id")? jsonHero.get("id").getAsInt() : null;

            listHero.add(hero);
        }

        for(String suffix : MASS_SUFFIX){
            for(ImageDota2 hero : listHero){
                URL url = new URL(URL_IMAGE_DOTA + hero.name + "_" + suffix);

                switch (suffix) {
                    case SUFFIX_FULL_DOTA: saveImage(url,path + FOLDER_LARGE + "dota2_hero_" + hero.id + "_" + SUFFIX_FULL_DOTA); break;
                    case SUFFIX_SB_DOTA: saveImage(url, path + FOLDER_SMALL + "dota2_hero_" + hero.id + "_" + SUFFIX_SB_DOTA); break;
                    case SUFFIX_LG_DOTA: saveImage(url, path + FOLDER_MEDIUM + "dota2_hero_" + hero.id + "_" + SUFFIX_LG_DOTA); break;
                    case SUFFIX_VERT_DOTA: saveImage(url,path + FOLDER_VERT + "dota2_hero_" + hero.id + "_" + SUFFIX_VERT_DOTA); break;
                }
            }
        }


    }

    private void saveImage(URL url, String urlPath) throws IOException{

        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream(urlPath);
        fos.write(response);
        fos.close();
    }

    public static JsonObject downloadJSONPage(String url) throws MalformedURLException, IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonText).getAsJsonObject();
            return jsonObject;
        } finally {
            is.close();
        }
    }

    public static String downloadWebPage(String url)throws MalformedURLException, IOException {
        HttpURLConnection httpcon = (HttpURLConnection) new URL(url).openConnection();
        httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpcon.getInputStream(), Charset.forName("UTF-8")));
            String text = readAll(rd);
            return text;
        } finally {
            httpcon.disconnect();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public class ImageDota2{

        public int id;
        public String name;
        public String Url;

        ImageDota2(){

        }
    }
}