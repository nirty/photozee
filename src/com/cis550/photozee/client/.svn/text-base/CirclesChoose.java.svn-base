package com.cis550.photozee.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.cellview.client.CellList;
import com.cis550.photozee.client.model.Circle;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Button;

public class CirclesChoose extends Composite {

	private AbsolutePanel circlechoose = new AbsolutePanel();
	static private CirclesChoose _instance = null;
	final FlexTable circleListTable = new FlexTable();
	static final private ArrayList<Integer> chosen_circles = new ArrayList<Integer>();
	private int userid = Integer.parseInt(Cookies.getCookie("userID"));

	private final UserProfileServiceAsync userprofileService = GWT
			.create(UserProfileService.class);

	public CirclesChoose() {
		initPage();
		initWidget(circlechoose);

	}

	public static CirclesChoose getInstance() {
		if (null == _instance) {
			_instance = new CirclesChoose();
		}
		return _instance;
	}

	private void initPage() {

		Button doneChoosing = new Button("Save and Go Back");
		doneChoosing.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				History.newItem("uploadphoto", true);
				RootPanel.get().clear();
				RootPanel.get().add(UploadPhoto.getInstance());
			}
		});
		circlechoose.add(doneChoosing, 63, 57);
		doneChoosing.setSize("171px", "60px");
		

		final ArrayList<Circle> list_of_circles = new ArrayList<Circle>();
		final ArrayList<CheckBox> list_of_widgets = new ArrayList<CheckBox>();
		circlechoose.setSize("1200px", "900px");

		Label lblPleaseSelectThe = new Label(
				"Please Select the Circles that you want the photo to make Visible");
		circlechoose.add(lblPleaseSelectThe, 404, 131);

		circlechoose.add(circleListTable, 216, 252);
		circleListTable.setSize("931px", "60px");

		userprofileService.getCircleid(userid,
				new AsyncCallback<ArrayList<Circle>>() {

					@Override
					public void onSuccess(ArrayList<Circle> result) {
						for (Circle circle : result) {
							list_of_circles.add(circle);
						}

						for (Circle circle : list_of_circles) {
							list_of_widgets.add(convert2Widgets(circle));
						}

						printCheckBoxes(list_of_widgets);
						;
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}
				});

	}

	private CheckBox convert2Widgets(Circle circle) {
		CheckBox checkBox = new CheckBox(circle.getCircle_name().toString());
		final Integer circle_id = circle.getCircle_id();
		checkBox.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				circleschosen(circle_id);

			}
		});
		return checkBox;

	}

	void circleschosen(Integer circleid) {
		
		if (chosen_circles.contains(circleid))
			chosen_circles.remove(circleid);
		else
			chosen_circles.add(circleid);
		
		/*StringBuilder st = new StringBuilder();
		for(Integer cir:chosen_circles){
			st.append(cir.toString());
		}
		circlechoose.add(new HTML(st.toString()));*/
	}

	void printCheckBoxes(ArrayList<CheckBox> result) {

		int no_of_circles = result.size();
		int ht = no_of_circles / 3;
		if (no_of_circles % 3 != 0)
			ht = ht + 1;
		int number = 0;
		for (int i = 0; i < ht; i++) {
			for (int j = 0; j < 3; j++) {
				if (number >= no_of_circles) {
				} else {

					circleListTable.setWidget(i, j, result.get(number));
					number = number + 1;
				}
			}
		}

	}


	public static ArrayList<Integer> getChosenCircles(){		
		return chosen_circles;
		
	}

}
