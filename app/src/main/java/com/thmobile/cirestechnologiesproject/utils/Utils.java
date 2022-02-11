package com.thmobile.cirestechnologiesproject.utils;

import android.content.SharedPreferences;

import java.util.ArrayList;

public class Utils {

    //first usage key to save in SharedPreferences
    public static final String FIRST_USAGE_KET = "first_usage";
    //number of tabs
    public static final int NUMBER_OF_TABS = 6;

    //Category names
    public static final String[] categoryNames = {
            "Science",
            "Business",
            "Sports",
            "Technology",
            "Startup",
            "Automobile"};

    //arraylists to save the data comes from server to save the internet connection and RAM
    public static ArrayList<DataModel> dataModels_Science = new ArrayList<>();
    public static ArrayList<DataModel> dataModels_Business = new ArrayList<>();
    public static ArrayList<DataModel> dataModels_Sports = new ArrayList<>();
    public static ArrayList<DataModel> dataModels_Technology = new ArrayList<>();
    public static ArrayList<DataModel> dataModels_Startup = new ArrayList<>();
    public static ArrayList<DataModel> dataModels_Automobile = new ArrayList<>();

    //JSON keys
    public static final String Array_Data = "data";
    public static final String author = "author";
    public static final String content = "content";
    public static final String date = "date";
    public static final String imageUrl = "imageUrl";
    public static final String readMoreUrl = "readMoreUrl";
    public static final String time = "time";
    public static final String title = "title";
    public static final String url = "url";

    //URL of JSONs
    public static final String BASE_URL_Science = "https://inshortsapi.vercel.app/news?category=science";
    public static final String BASE_URL_Business = "https://inshortsapi.vercel.app/news?category=business";
    public static final String BASE_URL_Sports = "https://inshortsapi.vercel.app/news?category=sports";
    public static final String BASE_URL_Technology = "https://inshortsapi.vercel.app/news?category=technology";
    public static final String BASE_URL_Startup = "https://inshortsapi.vercel.app/news?category=startup";
    public static final String BASE_URL_Automobile = "https://inshortsapi.vercel.app/news?category=automobile";

    //Accessed and Blocked Users
    public static UserAccount AccessUser = new UserAccount("muser", "mpassw0rd");
    public static UserAccount BlockedUser = new UserAccount("muser02", "mpassword");
}