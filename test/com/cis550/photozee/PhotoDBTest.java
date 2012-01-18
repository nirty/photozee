package com.cis550.photozee;

import java.util.ArrayList;
import java.util.List;

import com.cis550.photozee.client.model.Photo;
import com.cis550.photozee.server.dataaccess.PhotoDB;

import junit.framework.TestCase;

public class PhotoDBTest extends TestCase {

	public void testSavePhotos() {
		
		ArrayList<Integer> visibilityList = new ArrayList<Integer>();
		visibilityList.add(new Integer(33004));
		visibilityList.add(new Integer(33005));
		
		PhotoDB.savePhotos(33000, "http://media35.onsugar.com/files/2011/08/32/6/1852/18523990/849176685b683f76_Images_Food_B.gif", "Food at its best", "Food,Drinks,Glutton", new Integer(1), visibilityList);
		//PhotoDB.savePhotos(33000, "http://gallery.photo.net/sdphoto/14613834-md.jpg", "caption", "tag");
	}
	
	public void getPhotos() {
		
		
	Photo temp = PhotoDB.getPhoto(33000);
	System.out.println();
	}

	public void insertRating() {
		
		
		PhotoDB.savePhotoTagsNScore(33009,33009,"Ninth,nirty,Test,tagging",1 );
		System.out.println();
		}
	
	public void insertInv(){
		PhotoDB.InvertedIndex("hello,how,are,you,super,awesome,pictures", 33004);
	}
	
	public void searchInv(){
	List<Photo> temp=	PhotoDB.searchPhotos("shashi",33001);
	System.out.println("result");
	}
}
