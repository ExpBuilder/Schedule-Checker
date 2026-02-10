import java.util.ArrayList;

public class CanAttend {

	//precondition: Input "meetings" should be an ArrayList of properly defined MeetingInterval objects. 
	/*postcondition: This method will return a boolean on if the elements in ArrayList "meetings" overlap. 
	MeetingInterval objects "a" and "b" overlap if "a" has a startTime or endTime between those of "b", or the other way around, inclusive. 
	This also means that if "a" were to have a startTime that equaled the endTime of "b", "a" and "b" would overlap.*/
	public static boolean canAttend(ArrayList<MeetingInterval> meetings) {
		for (int i = 0; i < meetings.size(); i++) {
			int s1 = meetings.get(i).getStart();
			int e1 = meetings.get(i).getEnd();

			// Compare times to all other meetings
			for (int j = 0; j < meetings.size(); j++) {
				if (j != i) {
					int s2 = meetings.get(j).getStart();
					int e2 = meetings.get(j).getEnd();

					// Checks if meetings overlap
					if (s1 <= s2 && s2 <= e1) return false;
					if (s1 <= e2 && e2 <= e1) return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		ArrayList<MeetingInterval> meet = new ArrayList<MeetingInterval>();
		for(int i =0; i<10; i++) {
			int start = (int)(Math.random()*2399);
			int end = start + ((int)(Math.random()*(2399-start)));
			meet.add(new MeetingInterval(start, end));
		}
		System.out.println(canAttend(meet) ? "There is no conflict with attending "+meet+" meetings":"Can't attend "+meet+" meetings due to conflict");
		
		
		// Additional testing:
		meet = new ArrayList<MeetingInterval> ();
		meet.add(new MeetingInterval(100, 200));

		System.out.println(canAttend(meet) ? "\nThere is no conflict with attending "+meet+" meetings":"\nCan't attend "+meet+" meetings due to conflict");
		
		meet.add(new MeetingInterval(201, 300));

		System.out.println(canAttend(meet) ? "\nThere is no conflict with attending "+meet+" meetings":"\nCan't attend "+meet+" meetings due to conflict");
		
		meet.add(new MeetingInterval(100, 300));

		System.out.println(canAttend(meet) ? "\nThere is no conflict with attending "+meet+" meetings":"\nCan't attend "+meet+" meetings due to conflict");
		
		meet.set(2, new MeetingInterval(300, 400));

		System.out.println(canAttend(meet) ? "\nThere is no conflict with attending "+meet+" meetings":"\nCan't attend "+meet+" meetings due to conflict");
	}
}
