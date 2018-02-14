package com.example.piotrzarczynski.fishbook.Database.Model;

/**
 * Created by Piotr on 2018-01-11.
 */

public class Caught {

    public static final String TAG = Caught.class.getSimpleName();
    public static final String TABLE = "Caught";

    // Fish Table Columns names and types
    public static final String KEY_ID = "id";
        public static final String TYPE_ID = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String KEY_IDFISH = "idFish";
        public static final String TYPE_ID_FISH = "INTEGER NOT NULL";
    public static final String KEY_WEIGHT = "weight";
        public static final String TYPE_WEIGHT = "INTEGER";
    public static final String KEY_LENGTH = "length";
        public static final String TYPE_LENGTH = "INTEGER";
    public static final String KEY_IMG = "img";
        public static final String TYPE_IMG = "BLOB";
    public static final String KEY_CAUGHT_AT = "caught_at";
        public static final String TYPE_CAUGHT_AT = "DATETIME";
    public static final String KEY_DESCRIPTION = "description";
        public static final String TYPE_DESCRIPTION = "TEXT";

    // private variables
    private int m_iId;
    private int m_iIdFish;
    private int m_iWeight;
    private int m_iLength;
    private byte[] m_bImg; // picture of fish
    private String m_sCaughtAt;
    private String m_sDescription;
    /* Add somthing more */

    // Empty constructor
    public Caught(){
        /**/
    }

    // constructor with id
    public Caught(int iId, int iIdFish, int iWeight, int iLength, byte[] bImg, String sCaughtAt, String sDescription){
        this.m_iId = iId;
        this.m_iIdFish = iIdFish;
        this.m_iWeight = iWeight;
        this.m_iLength = iLength;
        this.m_bImg = bImg;
        this.m_sCaughtAt = sCaughtAt;
        this.m_sDescription = sDescription;
    }

    // constructor without id
    public Caught(int iIdFish, int iWeight, int iLength, byte[] bImg, String sCaughtAt, String sDescription){
        this.m_iIdFish = iIdFish;
        this.m_iWeight = iWeight;
        this.m_iLength = iLength;
        this.m_bImg = bImg;
        this.m_sCaughtAt = sCaughtAt;
        this.m_sDescription = sDescription;
    }

    /* get section */
    public int getId(){return m_iId;}
    public int getIdFish(){return m_iIdFish;}
    public int getWeight(){return m_iWeight;}
    public int getLength(){return m_iLength;}
    public byte[] getImg(){return m_bImg;}
    public String getCaughtAt(){return m_sCaughtAt;}
    public String getDescription(){return m_sDescription;}

    /* set section */
    public void setId(int iId){this.m_iId = iId;}
    public void setIdFish(int iIdFish){this.m_iIdFish = iIdFish;}
    public void setWeight(int iWeight){this.m_iWeight = iWeight;}
    public void setLength(int iLength){this.m_iLength = iLength;}
    public void setImg(byte[] bImg){this.m_bImg = bImg;}
    public void setCaughtAt(String sCaughtAt){this.m_sCaughtAt = sCaughtAt;}
    public void setDescription(String sDescription){this.m_sDescription = sDescription;}
}
