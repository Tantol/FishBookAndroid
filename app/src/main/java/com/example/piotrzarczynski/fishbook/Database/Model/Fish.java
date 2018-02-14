package com.example.piotrzarczynski.fishbook.Database.Model;

/**
 * Created by Piotr on 2018-01-11.
 */

public class Fish {

    public static final String TAG = Fish.class.getSimpleName();
    public static final String TABLE = "Fish";

    // Fish Table Columns names and types
    public static final String KEY_ID = "id";
        public static final String TYPE_ID = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String KEY_NAME = "name";
        public static final String TYPE_NAME = "TEXT NOT NULL";
    public static final String KEY_DESCRIPTION = "description";
        public static final String TYPE_DESCRIPTION = "TEXT";
    public static final String KEY_OCCUR = "occur";
        public static final String TYPE_OCCUR = "TEXT";
    public static final String KEY_IMG = "img";
        public static final String TYPE_IMG = "BLOB";
    public static final String KEY_CATCH = "catch";
        public static final String TYPE_CATCH = "BOOLEAN";

    // private variables
    private byte m_bCatch; // 0/1, false/true
    private int m_iId;
    private String m_sName;
    private String m_sDescription;
    private String m_sOccur; // where u can catch it
    private byte[] m_bImg; // picture of fish
    /* Add somthing more */

    // Empty constructor
    public Fish(){
        /**/
    }

    // constructor with id
    public Fish(int iId, String sName, String sDescription, String sOccur, byte[] bImg, byte bCatch){
        this.m_iId = iId;
        this.m_sName = sName;
        this.m_sDescription = sDescription;
        this.m_sOccur = sOccur;
        this.m_bImg = bImg;
        this.m_bCatch = bCatch; // 0/1, false/true
    }

    // constructor without id
    public Fish(String sName, String sDescription, String sOccur, byte[] bImg, byte bCatch){
        this.m_sName = sName;
        this.m_sDescription = sDescription;
        this.m_sOccur = sOccur;
        this.m_bImg = bImg;
        this.m_bCatch = bCatch; // 0/1, false/true
    }

    /* get section */
    public int getId(){return m_iId;}
    public String getName(){return m_sName;}
    public String getDescription(){return m_sDescription;}
    public String getOccur(){return m_sOccur;}
    public byte[] getImg(){return m_bImg;}
    public boolean isCatch(){
        if (m_bCatch == 0){
            return false;
        } else if (m_bCatch == 1) {
            return true;
        }
        return false;
    } // 0/1, false/true

    /* set section */
    public void setId(int iId){this.m_iId = iId;}
    public void setName(String sName){this.m_sName = sName;}
    public void setDescription(String sDescription){this.m_sDescription = sDescription;}
    public void setOccur(String sOccur){this.m_sOccur = sOccur;}
    public void setImg(byte[] bImg){this.m_bImg = bImg;}
    public void setCatch(byte bCatch){this.m_bCatch = bCatch;}
    public void setCatch(boolean bCatch){
        if (bCatch){
            this.m_bCatch = 1;
        } else if (!bCatch) {
            this.m_bCatch = 0;
        } else {
            // this.m_bCatch = 0;
        }
    } // 0/1, false/true

}
