package util;

public class ScreenLocations{

	public static final int[] MAXIMUM_BET = new int[]{855, 675};

	public static final int[] BLUE_BUTTON = new int[]{480, 610};
	public static final int[] GREEN_BUTTON = new int[]{700, 610};
	public static final int[] RED_BUTTON = new int[]{900, 625};
	public static final int[] TEXT_FIELD = new int[]{800, 700};
	
	public static final ScreencapSpecs CHECK_AVAILABLE = new ScreencapSpecs(675, 622, 2, 2, "checkAvailable", "png");

	public static final ScreencapSpecs COMMUNITY_1 = new ScreencapSpecs(517, 222, 15, 20, "community1", "png");
	public static final ScreencapSpecs COMMUNITY_2 = new ScreencapSpecs(585, 222, 15, 20, "community2", "png");
	public static final ScreencapSpecs COMMUNITY_3 = new ScreencapSpecs(653, 222, 15, 20, "community3", "png");
	public static final ScreencapSpecs COMMUNITY_4 = new ScreencapSpecs(721, 222, 15, 20, "community4", "png");
	public static final ScreencapSpecs COMMUNITY_5 = new ScreencapSpecs(789, 222, 15, 20, "community5", "png");

	public static final ScreencapSpecs HOLE6_1 = new ScreencapSpecs(761, 445, 15, 20, "hole1", "png");
	public static final ScreencapSpecs HOLE6_2 = new ScreencapSpecs(824, 445, 15, 20, "hole2", "png");

//	public static final ScreencapSpecs HOLE9_1 = new ScreencapSpecs(761, 445, 15, 20, "hole1", "png");
//	public static final ScreencapSpecs HOLE9_2 = new ScreencapSpecs(824, 445, 15, 20, "hole2", "png");

	public static final ScreencapSpecs TABLE6_BANKROLL_V = new ScreencapSpecs(791, 529, 10, 6, "bankroll_v", "png");
	public static final ScreencapSpecs TABLE6_BANKROLL_W = new ScreencapSpecs(801, 529, 10, 6, "bankroll_w", "png");
	public static final ScreencapSpecs TABLE6_BANKROLL_X = new ScreencapSpecs(811, 529, 10, 6, "bankroll_x", "png");
	public static final ScreencapSpecs TABLE6_BANKROLL_Y = new ScreencapSpecs(826, 529, 10, 6, "bankroll_y", "png");
	public static final ScreencapSpecs TABLE6_BANKROLL_Z = new ScreencapSpecs(836, 529, 10, 6, "bankroll_z", "png");
	
	public static final ScreencapSpecs TABLE6_BLANKSPOT = new ScreencapSpecs(670, 525, 4, 4, "blankspot", "png");

	public static final ScreencapSpecs TABLE6_D0 = new ScreencapSpecs(596, 158, 2, 2, "d.png", "png");
	public static final ScreencapSpecs TABLE6_D1 = new ScreencapSpecs(899, 158, 2, 2, "d.png", "png");
	public static final ScreencapSpecs TABLE6_D2 = new ScreencapSpecs(951, 254, 2, 2, "d.png", "png");
	public static final ScreencapSpecs TABLE6_D3 = new ScreencapSpecs(899, 416, 2, 2, "d.png", "png");
	public static final ScreencapSpecs TABLE6_D4 = new ScreencapSpecs(596, 416, 2, 2, "d.png", "png");
	public static final ScreencapSpecs TABLE6_D5 = new ScreencapSpecs(405, 254, 2, 2, "d.png", "png");

	private static final ScreencapSpecs TABLE6_P0 = new ScreencapSpecs(488, 82, 2, 2, "p0", "png");
	private static final ScreencapSpecs TABLE6_P1 = new ScreencapSpecs(789, 82, 2, 2, "p1", "png");
	private static final ScreencapSpecs TABLE6_P2 = new ScreencapSpecs(1046, 277, 2, 2, "p2", "png");
	private static final ScreencapSpecs TABLE6_P4 = new ScreencapSpecs(488, 492, 2, 2, "p4", "png");
	private static final ScreencapSpecs TABLE6_P5 = new ScreencapSpecs(254, 277, 2, 2, "p5", "png");
	
	public static final ScreencapSpecs[] TABLE6_OPPONENT_LOCATIONS = new ScreencapSpecs[]{TABLE6_P0, TABLE6_P1,
			TABLE6_P2, TABLE6_P4, TABLE6_P5};

	public static final ScreencapSpecs TABLE6_TURN = new ScreencapSpecs(886, 515, 2, 2, "myTurn", "png");
//	public static final ScreencapSpecs TABLE9_TURN = new ScreencapSpecs(735, 515, 2, 2, "myTurn", "png");
	
	public static final ScreencapSpecs PLAY_VWX_V = new ScreencapSpecs(688, 623, 10, 11, "digit1.png", "png");
	public static final ScreencapSpecs PLAY_VWX_W = new ScreencapSpecs(698, 623, 10, 11, "digit2.png", "png");
	public static final ScreencapSpecs PLAY_VWX_X = new ScreencapSpecs(708, 623, 10, 11, "digit3.png", "png");
	
	public static final ScreencapSpecs PLAY_X_X = new ScreencapSpecs(698, 623, 10, 11, "digit1.png", "png");
	
	public static final ScreencapSpecs PLAY_VWXYZ_V = new ScreencapSpecs(676, 623, 10, 11, "digit1.png", "png");
	public static final ScreencapSpecs PLAY_VWXYZ_W = new ScreencapSpecs(686, 623, 10, 11, "digit2.png", "png");
	public static final ScreencapSpecs PLAY_VWXYZ_X = new ScreencapSpecs(696, 623, 10, 11, "digit3.png", "png");
	public static final ScreencapSpecs PLAY_VWXYZ_Y = new ScreencapSpecs(711, 623, 10, 11, "digit4.png", "png");
	public static final ScreencapSpecs PLAY_VWXYZ_Z = new ScreencapSpecs(721, 623, 10, 11, "digit5.png", "png");
	
	public static final ScreencapSpecs PLAY_XYZ_X = new ScreencapSpecs(686, 623, 10, 11, "digit1.png", "png");
	public static final ScreencapSpecs PLAY_XYZ_Y = new ScreencapSpecs(701, 623, 10, 11, "digit2.png", "png");
	public static final ScreencapSpecs PLAY_XYZ_Z = new ScreencapSpecs(711, 623, 10, 11, "digit3.png", "png");
	
	public static final ScreencapSpecs PLAY_WX_W = new ScreencapSpecs(693, 623, 10, 11, "digit1.png", "png");
	public static final ScreencapSpecs PLAY_WX_X = new ScreencapSpecs(703, 623, 10, 11, "digit2.png", "png");
	
	public static final ScreencapSpecs PLAY_WXYZ_W = new ScreencapSpecs(681, 623, 10, 11, "digit1.png", "png");
	public static final ScreencapSpecs PLAY_WXYZ_X = new ScreencapSpecs(691, 623, 10, 11, "digit2.png", "png");
	public static final ScreencapSpecs PLAY_WXYZ_Y = new ScreencapSpecs(706, 623, 10, 11, "digit3.png", "png");
	public static final ScreencapSpecs PLAY_WXYZ_Z = new ScreencapSpecs(716, 623, 10, 11, "digit4.png", "png");
	

	public static final ScreencapSpecs REAL_XYZ_X = new ScreencapSpecs(691, 623, 10, 11, "digit1.png", "png");
	public static final ScreencapSpecs REAL_XYZ_Y = new ScreencapSpecs(706, 623, 10, 11, "digit2.png", "png");
	public static final ScreencapSpecs REAL_XYZ_Z = new ScreencapSpecs(716, 623, 10, 11, "digit3.png", "png");
	
	public static final ScreencapSpecs REAL_YZ_Y = new ScreencapSpecs(688, 623, 10, 11, "digit1.png", "png");
	public static final ScreencapSpecs REAL_YZ_Z = new ScreencapSpecs(698, 623, 10, 11, "digit2.png", "png");
	
	public static final ScreencapSpecs REAL_Z_Z = new ScreencapSpecs(693, 623, 10, 11, "digit1.png", "png");
}