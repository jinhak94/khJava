package com.collection.list.music.view;

import java.util.Comparator;

import com.collection.list.music.model.vo.Music;

public class MusicSingerDescending implements Comparator<Music>{
	@Override
	public int compare(Music m1, Music m2) {
		return m2.getSinger().compareTo(m1.getSinger());
	}
}
