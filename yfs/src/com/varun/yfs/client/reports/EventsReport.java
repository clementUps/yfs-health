package com.varun.yfs.client.reports;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.user.client.Element;

public class EventsReport extends LayoutContainer
{
	public EventsReport()
	{
		setHeight("700");
	}

	@Override
	protected void onRender(Element parent, int index)
	{

		super.onRender(parent, index);
		
		ContentPanel cpOuterContainer = new ContentPanel();
		cpOuterContainer.setHeading("Reporting -> Reports -> Events");
		add(cpOuterContainer);

		setScrollMode(Scroll.AUTOY);
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new TableLayout(3));

		DateField dtfldFromDate = new DateField();
		dtfldFromDate.setFieldLabel("From Date");
		dtfldFromDate.setAllowBlank(false);
		LayoutContainer frmpnlFromDate = new LayoutContainer();
		frmpnlFromDate.setLayout(new FormLayout());
		frmpnlFromDate.add(dtfldFromDate, new FormData("100%"));

		TableData td_frmpnlFromDate = new TableData();
		td_frmpnlFromDate.setMargin(5);
		td_frmpnlFromDate.setPadding(5);
		layoutContainer.add(frmpnlFromDate, td_frmpnlFromDate);

		DateField dtfldToDate = new DateField();
		dtfldToDate.setFieldLabel("To Date");
		dtfldToDate.setAllowBlank(false);
		LayoutContainer frmpnlToDate = new LayoutContainer();
		frmpnlToDate.setLayout(new FormLayout());
		frmpnlToDate.add(dtfldToDate, new FormData("100%"));

		TableData td_frmpnlToDate = new TableData();
		td_frmpnlToDate.setPadding(5);
		td_frmpnlToDate.setMargin(5);
		layoutContainer.add(frmpnlToDate, td_frmpnlToDate);

		LayoutContainer frmpnlRefresh = new LayoutContainer();
		frmpnlRefresh.setLayout(new FormLayout());

		Button btnRefresh = new Button("Get Report");
		frmpnlRefresh.add(btnRefresh, new FormData("100%"));
		TableData td_frmpnlRefresh = new TableData();
		td_frmpnlRefresh.setPadding(5);
		td_frmpnlRefresh.setMargin(5);
		layoutContainer.add(frmpnlRefresh, td_frmpnlRefresh);
		frmpnlRefresh.setBorders(true);

		add(layoutContainer);

		FormPanel lcReportingParams = new FormPanel();
		lcReportingParams.setHeaderVisible(false);
		lcReportingParams.setSize("", "700");

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		ColumnConfig clmncnfgNewColumn = new ColumnConfig("date", "Date", 150);
		configs.add(clmncnfgNewColumn);

		ColumnConfig clmncnfgNewColumn_1 = new ColumnConfig("eventType", "Event Type", 150);
		configs.add(clmncnfgNewColumn_1);

		ColumnConfig clmncnfgNewColumn_2 = new ColumnConfig("eventLocation", "Event Location", 150);
		configs.add(clmncnfgNewColumn_2);

		ColumnConfig clmncnfgNewColumn_3 = new ColumnConfig("noScreened", "Number Screened", 150);
		configs.add(clmncnfgNewColumn_3);

		ColumnConfig clmncnfgNewColumn_4 = new ColumnConfig("noRequiringTreatment", "Requiring Treatment", 150);
		configs.add(clmncnfgNewColumn_4);

		ColumnConfig clmncnfgNewColumn_5 = new ColumnConfig("noTreated", "Number Treated", 150);
		configs.add(clmncnfgNewColumn_5);

		ColumnConfig clmncnfgNewColumn_6 = new ColumnConfig("volunteers", "Volunteers", 150);
		configs.add(clmncnfgNewColumn_6);

		ColumnConfig clmncnfgNewColumn_7 = new ColumnConfig("medicalTeam", "Medical Team", 150);
		configs.add(clmncnfgNewColumn_7);

		Grid<ModelData> gridEvents = new Grid<ModelData>(new ListStore<ModelData>(), new ColumnModel(configs));
		gridEvents.setHeight("350");
		gridEvents.setBorders(true);

		FormData fd_gridStatusOfTreatment = new FormData("100%");
		fd_gridStatusOfTreatment.setMargins(new Margins(0, 0, 5, 0));
		lcReportingParams.add(gridEvents, fd_gridStatusOfTreatment);

		lcReportingParams.setLayoutData(new Margins(5, 5, 5, 5));
		add(lcReportingParams);

	}
}