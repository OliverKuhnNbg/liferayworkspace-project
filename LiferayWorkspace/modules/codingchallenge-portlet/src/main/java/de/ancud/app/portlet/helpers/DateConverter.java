package de.ancud.app.portlet.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.ancud.app.service.model.Task;

public class DateConverter {

	public List<String> getDateAsStringList(List<Task> tasks) {
		List<String> dateStringyfiedList = new ArrayList<>();
		for (Task task : tasks) {
			String dateStr = convertDateToDateString(task.getDueDate());
			dateStringyfiedList.add(dateStr);
		}
		return dateStringyfiedList;
	}
	
	public Date convertDateStrToDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
		LocalDate localDate = LocalDate.parse(dateString, formatter);
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		
		return date;
	}
	
	private String convertDateToDateString(Date d) {  
        DateFormat dateFormat = new SimpleDateFormat("dd. MMMM yyyy");
        String strDate = dateFormat.format(d); 
        
		return strDate;
	}

}
