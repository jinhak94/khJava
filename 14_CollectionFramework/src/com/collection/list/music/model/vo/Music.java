package com.collection.list.music.model.vo;

import java.util.Objects;

public class Music {
	private String title;
	private String singer;
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Music(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "Music [title=" + title + ", singer=" + singer + "]";
	}
	
	
	
	@Override
    public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(!(obj instanceof Music)) {
			return false;
		}
		Music m = (Music)obj;
        if(singer == null) {
        	if(m.getSinger()!=null) {
        		return false;
        	}
        }else{
			if(!this.getSinger().equals(m.getSinger())){
				return false;
			}
		}
        if(title == null) {
        	if(m.getTitle()!=null) {
        		return false;
        	}
        }else{
        	if(!this.getTitle().equals(m.getTitle())){
        		return false;
        	}
        }
		
		return true;
    }
	@Override
    public int hashCode(){
		return Objects.hash(title, singer);
	};
}
