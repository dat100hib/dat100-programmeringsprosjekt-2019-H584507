package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}

		return min;
		// TODO - SLUTT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] latitudes = new double[gpspoints.length];
		
		for(int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] longitudes = new double[gpspoints.length];
		
		for(int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START

		latitude1 = toRadians(gpspoint1.getLatitude());
		latitude2 = toRadians(gpspoint2.getLatitude());
		longitude1 = toRadians(gpspoint1.getLongitude());
		longitude2 = toRadians(gpspoint2.getLongitude());

		double la = latitude2 - latitude1;
		double lo = longitude2 - longitude1;
		
		double a = Math.pow(sin(la/2),2) + cos(latitude1)*cos(latitude2)*Math.pow(sin(lo/2),2);
		double c = 2*atan2(sqrt(a), sqrt(1-a));
		
		return d = R*c;
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		secs = gpspoint2.getTime() - gpspoint1.getTime();
		double distance = distance(gpspoint1, gpspoint2);
		
		return speed = (distance/secs)*3.6;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		int tt = secs/3600;
		int mm = secs%3600/60;
		int ss = secs%3600%60;
		String T = Integer.toString(tt);
		String M = Integer.toString(mm);
		String S = Integer.toString(ss);
		
		if(tt < 10) {
			T="0" + Integer.toString(tt);
		}
		
		if(mm < 10) {
			M="0" + Integer.toString(mm);
		}
		
		if(ss < 10) {
			S="0" + Integer.toString(ss);
		}
		
		timestr = "  " + T + TIMESEP + M + TIMESEP + S;
		return timestr;
		
		// TODO - SLUTT

	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		str = String.format("%10.2f", d);
		
		return str;
		// TODO - SLUTT
		
	}
}
