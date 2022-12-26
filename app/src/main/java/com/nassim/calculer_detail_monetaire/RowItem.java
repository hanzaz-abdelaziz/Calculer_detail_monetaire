package com.nassim.calculer_detail_monetaire;

public class RowItem {

    private final String title;
    private final int value;

    public RowItem(String title, int value){
        this.title = title;
        this.value = value;
    }

    public String getTitle(){
        return this.title;
    }
    public int getValue(){
        return this.value;
    }
}
