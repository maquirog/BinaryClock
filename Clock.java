

package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.Calendar;


public class Clock {
	
	private static final Color COLOR_ON = Color.WHITE;
	private static final Color COLOR_OFF = Color.gray(0.3);
	
	/////////////////////////////Seconds
	@FXML private Circle secUni0;
	@FXML private Circle secUni1;
	@FXML private Circle secUni2;
	@FXML private Circle secUni3;
	
	@FXML private Circle secDec0;
	@FXML private Circle secDec1;
	@FXML private Circle secDec2;
	
	/////////////////////////////Minutes
	@FXML private Circle minUni0;
	@FXML private Circle minUni1;
	@FXML private Circle minUni2;
	@FXML private Circle minUni3;
	
	@FXML private Circle minDec0;
	@FXML private Circle minDec1;
	@FXML private Circle minDec2;
	
	
	/////////////////////////////Hours
	@FXML private Circle hourUni0;
	@FXML private Circle hourUni1;
	@FXML private Circle hourUni2;
	@FXML private Circle hourUni3;
	
	@FXML private Circle hourDec0;
	@FXML private Circle hourDec1;
	
	
	/////////////////////////////Days
	@FXML private Circle dayUni0;
	@FXML private Circle dayUni1;
	@FXML private Circle dayUni2;
	@FXML private Circle dayUni3;
	
	@FXML private Circle dayDec1;
	@FXML private Circle dayDec0;
	
	
	/////////////////////////////Months
	@FXML private Circle monthUni0;
	@FXML private Circle monthUni1;
	@FXML private Circle monthUni2;
	@FXML private Circle monthUni3;
	
	@FXML private Circle monthDec0;
	
	
	/////////////////////////////Years
	@FXML private Circle yearUni0;
	@FXML private Circle yearUni1;
	@FXML private Circle yearUni2;
	@FXML private Circle yearUni3;
	
	@FXML private Circle yearDec0;
	@FXML private Circle yearDec1;
	@FXML private Circle yearDec2;
	@FXML private Circle yearDec3;
	
	@FXML private Circle yearHund0;
	@FXML private Circle yearHund1;
	@FXML private Circle yearHund2;
	@FXML private Circle yearHund3;
	
	@FXML private Circle yearThou0;
	@FXML private Circle yearThou1;
	@FXML private Circle yearThou2;
	@FXML private Circle yearThou3;
	
	
	/////////////////////////////Labels
	@FXML private Label hourLabel;
	@FXML private Label twoPoints1;
	@FXML private Label minLabel;
	@FXML private Label twoPoints0;
	@FXML private Label secLabel;
	
	@FXML private Label dayLabel;
	@FXML private Label slash1;
	@FXML private Label monthLabel;
	@FXML private Label slash0;
	@FXML private Label yearLabel;
	
	
	boolean color = false;
	boolean print = false;
	
	Calendar time;


	boolean began = false;
	boolean showHideT = false;
	boolean showHideD = false;
	
	int mySeconds = 0;
	int myMinutes = 0;
	int myHours = 0;
	
	public void clockRun() {
		
		if(began == false) {
			Timeline timeline = new Timeline(
					new KeyFrame(Duration.seconds(0),
					new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent actionEvent) {
							
							time = Calendar.getInstance();
							
							int decHour = 0;
							int uniHour = 0;
							int decMin = 0;
							int uniMin = 0;
							int decSec = 0;
							int uniSec = 0;
							
							int timeToSetIntHour = 0;
							int timeToSetIntMin = 0;
							int timeToSetIntSec = 0;
							
							int decDay = 0;
							int uniDay = 0;
							int decMonth = 0;
							int uniMonth = 0;
							int thouYear = 0;
							int hundYear = 0;
							int decYear = 0;
							int uniYear = 0;
							
							int dateToSetIntYear = 0;
							int dateToSetIntMonth = 0;
							int dateToSetIntDay = 0;
						
							
							
							uniSec = (time.get(Calendar.SECOND)) % 10;
							decSec = ((time.get(Calendar.SECOND))/10) % 10;
							uniMin = (time.get(Calendar.MINUTE)) % 10;
							decMin = ((time.get(Calendar.MINUTE))/10) % 10;
							uniHour = (time.get(Calendar.HOUR_OF_DAY)) % 10;
							decHour = ((time.get(Calendar.HOUR_OF_DAY))/10) % 10;
							writeTime(decHour, uniHour, decMin, uniMin, decSec, uniSec);
							
							uniDay = (time.get(Calendar.DAY_OF_MONTH)) % 10;
							decDay = ((time.get(Calendar.DAY_OF_MONTH))/10) % 10;
							uniMonth = (time.get(Calendar.MONTH) + 1) % 10;
							decMonth = ((time.get(Calendar.MONTH))/10) % 10;
							uniYear = (time.get(Calendar.YEAR)) % 10;
							decYear = ((time.get(Calendar.YEAR))/10) % 10;
							hundYear = ((time.get(Calendar.YEAR))/100) % 10;
							thouYear = ((time.get(Calendar.YEAR))/1000) % 10;
							writeDate(decDay, uniDay, decMonth, uniMonth, thouYear, hundYear, decYear, uniYear);
							
							timeToSetIntHour = time.get(Calendar.HOUR_OF_DAY);
							timeToSetIntMin = time.get(Calendar.MINUTE);
							timeToSetIntSec = time.get(Calendar.SECOND);
							showHideTime(timeToSetIntHour, timeToSetIntMin, timeToSetIntSec);
							
							dateToSetIntYear = time.get(Calendar.YEAR);
							dateToSetIntMonth = time.get(Calendar.MONTH) + 1;
							dateToSetIntDay = time.get(Calendar.DAY_OF_MONTH);
							showHideDate(dateToSetIntYear, dateToSetIntMonth, dateToSetIntDay);
							
							System.out.println(time.get(Calendar.HOUR_OF_DAY) + ":" + time.get(Calendar.MINUTE) + ":" + time.get(Calendar.SECOND) + "\t" + time.get(Calendar.DAY_OF_MONTH) + "/" + (time.get(Calendar.MONTH) + 1) + "/" + time.get(Calendar.YEAR));
						}
					}),
					new KeyFrame(Duration.millis(10)));
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();
			began = true;
		}
	}
	
	public void clockShowHideTime() {
		showHideT = !showHideT;
	}
	
	public void clockShowHideDate() {
		showHideD = !showHideD;
	}
	
	private void writeDate(int decDay, int uniDay, int decMonth, int uniMonth, int thouYear, int hundYear, int decYear, int uniYear) {
		if((uniDay & 1) != 0) {
			dayUni0.setFill(COLOR_ON);
			
		}
		else {
			dayUni0.setFill(COLOR_OFF);
		}
		
		if((uniDay & 2) != 0) {
			dayUni1.setFill(COLOR_ON);
		}
		else {
			dayUni1.setFill(COLOR_OFF);
		}
		
		if((uniDay & 4) != 0) {
			dayUni2.setFill(COLOR_ON);
		}
		else {
			dayUni2.setFill(COLOR_OFF);
		}
		
		if((uniDay & 8) != 0) {
			dayUni3.setFill(COLOR_ON);
		}
		else {
			dayUni3.setFill(COLOR_OFF);
		}
		
		
		
		if((decDay & 1) != 0) {
			dayDec0.setFill(COLOR_ON);
		}
		else {
			dayDec0.setFill(COLOR_OFF);
		}
		
		if((decDay & 2) != 0) {
			dayDec1.setFill(COLOR_ON);
		}
		else {
			dayDec1.setFill(COLOR_OFF);
		}
		


		
		if((uniMonth & 1) != 0) {
			monthUni0.setFill(COLOR_ON);
		}
		else {
			monthUni0.setFill(COLOR_OFF);
		}
		
		if((uniMonth & 2) != 0) {
			monthUni1.setFill(COLOR_ON);
		}
		else {
			monthUni1.setFill(COLOR_OFF);
		}
		
		if((uniMonth & 4) != 0) {
			monthUni2.setFill(COLOR_ON);
		}
		else {
			monthUni2.setFill(COLOR_OFF);
		}
		
		if((uniMonth & 8) != 0) {
			monthUni3.setFill(COLOR_ON);
		}
		else {
			monthUni3.setFill(COLOR_OFF);
		}
		
		
		
		if((decMonth & 1) != 0) {
			monthDec0.setFill(COLOR_ON);
		}
		else {
			monthDec0.setFill(COLOR_OFF);
		}
		
		
		
		if((uniYear & 1) != 0) {
			yearUni0.setFill(COLOR_ON);
		}
		else {
			hourUni0.setFill(COLOR_OFF);
		}
		
		if((uniYear & 2) != 0) {
			yearUni1.setFill(COLOR_ON);
		}
		else {
			yearUni1.setFill(COLOR_OFF);
		}
		
		if((uniYear & 4) != 0) {
			yearUni2.setFill(COLOR_ON);
		}
		else {
			yearUni2.setFill(COLOR_OFF);
		}
		
		if((uniYear & 8) != 0) {
			yearUni3.setFill(COLOR_ON);
		}
		else {
			yearUni3.setFill(COLOR_OFF);
		}
		
		
		if((decYear & 1) != 0) {
			yearDec0.setFill(COLOR_ON);
		}
		else {
			yearDec0.setFill(COLOR_OFF);
		}
		
		if((decYear & 2) != 0) {
			yearDec1.setFill(COLOR_ON);
		}
		else {
			yearDec1.setFill(COLOR_OFF);
		}
		
		if((decYear & 4) != 0) {
			yearDec2.setFill(COLOR_ON);
		}
		else {
			yearDec2.setFill(COLOR_OFF);
		}
		
		if((decYear & 8) != 0) {
			yearDec3.setFill(COLOR_ON);
		}
		else {
			yearDec3.setFill(COLOR_OFF);
		}
		
		
		if((hundYear & 1) != 0) {
			yearHund0.setFill(COLOR_ON);
		}
		else {
			yearHund0.setFill(COLOR_OFF);
		}
		
		if((hundYear & 2) != 0) {
			yearHund1.setFill(COLOR_ON);
		}
		else {
			yearHund1.setFill(COLOR_OFF);
		}
		
		if((hundYear & 4) != 0) {
			yearHund2.setFill(COLOR_ON);
		}
		else {
			yearHund2.setFill(COLOR_OFF);
		}
		
		if((hundYear & 8) != 0) {
			yearHund3.setFill(COLOR_ON);
		}
		else {
			yearHund3.setFill(COLOR_OFF);
		}
		
		if((thouYear & 1) != 0) {
			yearThou0.setFill(COLOR_ON);
		}
		else {
			yearThou0.setFill(COLOR_OFF);
		}
		
		if((thouYear & 2) != 0) {
			yearThou1.setFill(COLOR_ON);
		}
		else {
			yearThou1.setFill(COLOR_OFF);
		}
		
		if((thouYear & 4) != 0) {
			yearThou2.setFill(COLOR_ON);
		}
		else {
			yearThou2.setFill(COLOR_OFF);
		}
		
		if((thouYear & 8) != 0) {
			yearThou3.setFill(COLOR_ON);
		}
		else {
			yearThou3.setFill(COLOR_OFF);
		}
	}
	
	private void writeTime(int decHour, int uniHour, int decMin, int uniMin, int decSec, int uniSec) {
		
		
		if((uniSec & 1) != 0) {
			secUni0.setFill(COLOR_ON);
			
		}
		else {
			secUni0.setFill(COLOR_OFF);
		}
		
		if((uniSec & 2) != 0) {
			secUni1.setFill(COLOR_ON);
		}
		else {
			secUni1.setFill(COLOR_OFF);
		}
		
		if((uniSec & 4) != 0) {
			secUni2.setFill(COLOR_ON);
		}
		else {
			secUni2.setFill(COLOR_OFF);
		}
		
		if((uniSec & 8) != 0) {
			secUni3.setFill(COLOR_ON);
		}
		else {
			secUni3.setFill(COLOR_OFF);
		}
		
		
		
		if((decSec & 1) != 0) {
			secDec0.setFill(COLOR_ON);
		}
		else {
			secDec0.setFill(COLOR_OFF);
		}
		
		if((decSec & 2) != 0) {
			secDec1.setFill(COLOR_ON);
		}
		else {
			secDec1.setFill(COLOR_OFF);
		}
		
		if((decSec & 4) != 0) {
			secDec2.setFill(COLOR_ON);
		}
		else {
			secDec2.setFill(COLOR_OFF);
		}


		
		if((uniMin & 1) != 0) {
			minUni0.setFill(COLOR_ON);
		}
		else {
			minUni0.setFill(COLOR_OFF);
		}
		
		if((uniMin & 2) != 0) {
			minUni1.setFill(COLOR_ON);
		}
		else {
			minUni1.setFill(COLOR_OFF);
		}
		
		if((uniMin & 4) != 0) {
			minUni2.setFill(COLOR_ON);
		}
		else {
			minUni2.setFill(COLOR_OFF);
		}
		
		if((uniMin & 8) != 0) {
			minUni3.setFill(COLOR_ON);
		}
		else {
			minUni3.setFill(COLOR_OFF);
		}
		
		
		
		if((decMin & 1) != 0) {
			minDec0.setFill(COLOR_ON);
		}
		else {
			minDec0.setFill(COLOR_OFF);
		}
		
		if((decMin & 2) != 0) {
			minDec1.setFill(COLOR_ON);
		}
		else {
			minDec1.setFill(COLOR_OFF);
		}
		
		if((decMin & 4) != 0) {
			minDec2.setFill(COLOR_ON);
		}
		else {
			minDec2.setFill(COLOR_OFF);
		}
		
		
		
		if((uniHour & 1) != 0) {
			hourUni0.setFill(COLOR_ON);
		}
		else {
			hourUni0.setFill(COLOR_OFF);
		}
		
		if((uniHour & 2) != 0) {
			hourUni1.setFill(COLOR_ON);
		}
		else {
			hourUni1.setFill(COLOR_OFF);
		}
		
		if((uniHour & 4) != 0) {
			hourUni2.setFill(COLOR_ON);
		}
		else {
			hourUni2.setFill(COLOR_OFF);
		}
		
		if((uniHour & 8) != 0) {
			hourUni3.setFill(COLOR_ON);
		}
		else {
			hourUni3.setFill(COLOR_OFF);
		}
		
		
		
		if((decHour & 1) != 0) {
			hourDec0.setFill(COLOR_ON);
		}
		else {
			hourDec0.setFill(COLOR_OFF);
		}
		
		if((decHour & 2) != 0) {
			hourDec1.setFill(COLOR_ON);
		}
		else {
			hourDec1.setFill(COLOR_OFF);
		}
	}

	private void showHideDate(int dateToSetIntYear, int dateToSetIntMonth, int dateToSetIntDay) {
		if(showHideD) {								
			String dateToSetString;
			
			if(dateToSetIntDay < 10)
				dateToSetString = "0" + Integer.toString(dateToSetIntDay);
			else
				dateToSetString = Integer.toString(dateToSetIntDay);
			dayLabel.setText(dateToSetString);
			showHideD = true;
			
			slash1.setText("/");
			
			if(dateToSetIntMonth < 10)
				dateToSetString = "0" + Integer.toString(dateToSetIntMonth);
			else
				dateToSetString = Integer.toString(dateToSetIntMonth);
			monthLabel.setText(dateToSetString);
			
			slash0.setText("/");
			
			if(dateToSetIntYear < 10)
				dateToSetString = "0" + Integer.toString(dateToSetIntYear);
			else
				dateToSetString = Integer.toString(dateToSetIntYear);
			yearLabel.setText(dateToSetString);
		
		}
		else {
			yearLabel.setText(" ");
			slash1.setText(" ");
			monthLabel.setText(" ");
			slash0.setText(" ");
			dayLabel.setText(" ");
			showHideD = false;
		}
	}
	
	private void showHideTime(int timeToSetIntHour, int timeToSetIntMin, int timeToSetIntSec) {
		if(showHideT) {								
			String timeToSetString;
			
			if(timeToSetIntHour < 10)
				timeToSetString = "0" + Integer.toString(timeToSetIntHour);
			else
				timeToSetString = Integer.toString(timeToSetIntHour);
			hourLabel.setText(timeToSetString);
			
			twoPoints1.setText(":");
			
			if(timeToSetIntMin < 10)
				timeToSetString = "0" + Integer.toString(timeToSetIntMin);
			else
				timeToSetString = Integer.toString(timeToSetIntMin);
			minLabel.setText(timeToSetString);
			
			twoPoints0.setText(":");
			
			if(timeToSetIntSec < 10)
				timeToSetString = "0" + Integer.toString(timeToSetIntSec);
			else
				timeToSetString = Integer.toString(timeToSetIntSec);
			secLabel.setText(timeToSetString);
			showHideT = true;
		}
		else {
			hourLabel.setText(" ");
			twoPoints1.setText(" ");
			minLabel.setText(" ");
			twoPoints0.setText(" ");
			secLabel.setText(" ");
			showHideT = false;
		}
	}
	
}

