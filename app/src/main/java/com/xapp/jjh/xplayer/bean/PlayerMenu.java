package com.xapp.jjh.xplayer.bean;

import android.graphics.Color;

import com.xapp.jjh.xui.bean.BaseMenuItem;

import cn.ikan.libs.player.setting.DecodeMode;

/**
 * Created by Taurus on 2016/8/23.
 */
public class PlayerMenu extends BaseMenuItem {

    public static final int DECODE_MODE_NOT_SETTING = -1;
    public static final int DECODE_MODE_CODE_SOFT = 0;
    public static final int DECODE_MODE_CODE_HARD = 1;
    public static final int DECODE_MODE_CODE_MEDIA_PLAYER = 2;
    public static final int DECODE_MODE_CODE_EXO_PLAYER = 3;

    private int decodeModeCode;

    public PlayerMenu() {
    }

    public PlayerMenu(int iconId, String itemText) {
        super(iconId, itemText);
    }

    public PlayerMenu(int decodeModeCode,int iconId, String itemText){
        super(iconId, itemText);
        this.decodeModeCode = decodeModeCode;
    }

    public int getDecodeModeCode() {
        return decodeModeCode;
    }

    public void setDecodeModeCode(int decodeModeCode) {
        this.decodeModeCode = decodeModeCode;
    }

    public DecodeMode getDecodeMode(int decodeModeCode){
        if(decodeModeCode == DECODE_MODE_CODE_SOFT){
            return DecodeMode.SOFT;
        }else if(decodeModeCode == DECODE_MODE_CODE_HARD){
            return DecodeMode.HARD;
        }else if(decodeModeCode == DECODE_MODE_CODE_MEDIA_PLAYER){
            return DecodeMode.MEDIA_PLAYER;
        }else if(decodeModeCode == DECODE_MODE_CODE_EXO_PLAYER){
            return DecodeMode.EXO_PLAYER;
        }
        return DecodeMode.SOFT;
    }

    @Override
    public int getItemPartLineColor() {
        return Color.parseColor("#22000000");
    }

    @Override
    public int getItemTextColor() {
        return Color.parseColor("#444444");
    }
}
