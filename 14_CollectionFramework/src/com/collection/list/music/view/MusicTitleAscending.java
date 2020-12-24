package com.collection.list.music.view;

import java.util.Comparator;

import com.collection.list.music.model.vo.Music;

public class MusicTitleAscending implements Comparator<Music>{
	@Override
	public int compare(Music m1, Music m2) {
		return m1.getTitle().compareTo(m2.getTitle());
	}
}
