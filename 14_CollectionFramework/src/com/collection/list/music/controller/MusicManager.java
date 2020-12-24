package com.collection.list.music.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.collection.list.music.model.vo.Music;

public class MusicManager {
	Scanner sc = new Scanner(System.in);
	ArrayList<Music> mList = new ArrayList<>();{
		mList.add(new Music("Martini blue","DPR Live"));
		mList.add(new Music("Addicted","Michael Carreon"));
		mList.add(new Music("미안해","양다일"));
		mList.add(new Music("Options","Toni Romiti"));
		mList.add(new Music("Keep me waiting","The Bonfyre"));
	}

	public List<Music> selectList(){
		return mList;
	}
	//마지막에 추가
	public void addList(Music m) {
		mList.add(m);
	}
	//처음에 추가
	public void addAtZero(Music m) {
		mList.add(0,m);
	}
	
	public boolean removeMusic(String str) {
		Iterator<Music> iter = mList.iterator();
		int num = 0;
		while(iter.hasNext()) {
			Music m = iter.next();
			if(m.getTitle().equals(str)) {
				break;
			}
			num++;
		}
		if(num == mList.size()) {
			return false;
		}
		mList.remove(num);
		return true;
	}
	
	public boolean replaceMusic(Music oldMusic, Music newMusic) {
		Iterator<Music> iter = mList.iterator();
		int num = 0;
		while(iter.hasNext()) {
			Music m = iter.next();
			if(m.equals(oldMusic)) {
				break;
			}
			num++;
		}
		if(num == mList.size()) {
			return false;
		}
		mList.set(num, newMusic);
		return true;
	}
	
	public List<Music> searchMusicByTitle(String title){
		List<Music> list = new ArrayList<>();
		Iterator<Music> iter = mList.iterator();
		int num = 0;
		while(iter.hasNext()) {
			Music m = iter.next();
			if(m.getTitle().contains(title)) {
				list.add(m);
				num++;
			}
		}
		if(num == 0) {
			return null;
		}
		return list;
	}
	
	public List<Music> searchMusicBySinger(String singer){
		List<Music> list = new ArrayList<>();
		Iterator<Music> iter = mList.iterator();
		int num = 0;
		while(iter.hasNext()) {
			Music m = iter.next();
			if(m.getSinger().equals(singer)) {
				list.add(m);
				num++;
			}
		}
		if(num == 0) {
			return null;
		}
		return list;
	}
	
	public List<Music> orderBy(Comparator<Music> c){
		List<Music> m = 
				(List<Music>)((ArrayList<Music>)this.mList).clone();
		Collections.sort(m, c);
		return m;
	}
	
}
