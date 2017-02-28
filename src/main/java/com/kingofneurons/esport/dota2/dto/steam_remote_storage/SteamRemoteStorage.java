package com.kingofneurons.esport.dota2.dto.steam_remote_storage;

public class SteamRemoteStorage {

    private String filename;
    private String url;
    private int size;

    public String getFilename() {
        return filename;
    }

    public String getUrl() {
        return url;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "SteamRemoteStorage{" +
                ", filename='" + filename + '\'' +
                ", url='" + url + '\'' +
                ", size=" + size +
                '}';
    }
}
