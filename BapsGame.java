import java.awt.*;
import java.awt.event.*;
import javax.swing.*; //add libraries

public class BapsGame extends JFrame
{
	static Panel1 p1;
	public static void main (String[]args)
	{
		BapsGame mp = new BapsGame();
	}
	public BapsGame()
	{
		super("BAPS"); //title the game
		setSize(1000,640);//a rectangular panel
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // close when user clicks "x"
		setLocation(0,0); // start at the top left corner
		setResizable(false); //can't be resize
		p1 = new Panel1();//call Panel
		setContentPane(p1);
		setVisible(true);//make the panel visible
	}
}
class Panel1 extends JPanel //the class that holds all the cards and allows the user to play the game
{
	private CardLayout cards;
	private MainPanel cardpanel1;
	private LevelPanel cardpanel2;
	private PlayMode123 cardpanel3;
	private Instructions cardpanel4;
	private Image bapsImage, homeImage; 
	private JButton homeButton;
	private String pGoal, aGoal;
	//intialize all the variables
	public Panel1()
	{
		//setLayout(null);
		homeButton = new JButton("Home");
		bapsImage = Toolkit.getDefaultToolkit().getImage("BAPS1.gif");//add image of BAPS
		cards = new CardLayout();//use cardlayout
		setLayout(cards);//use cardlayout
		cardpanel1 = new MainPanel();
		cardpanel2 = new LevelPanel();
		cardpanel3 = new PlayMode123();
		cardpanel4 = new Instructions(); //initial all panels into cardlayout
		add(cardpanel1,"MainPanel");
		add(cardpanel2,"LevelPanel");
		add(cardpanel3,"PlayMode123");
		add(cardpanel4,"Instructions"); //add all panels into cardlayout
	}
	class MainPanel extends JPanel implements ActionListener
	{
		private JButton mainB1, mainB2;
		MainPanel()
		{
			setLayout(null);//uses custom layout so I can change the location and size of buttons
			setBackground(Color.PINK);//select pink as background color
			mainB1 = new JButton("PLAY");//instantiate button named play into mainB1
			mainB2 = new JButton("INSTRUCTIONS");//instantiate button named explore into mainB2
			//mainB3 = new JButton(bapsImage);//add button with pic1, our game logo`
			mainB1.addActionListener(this); 
			mainB2.addActionListener(this); //add actionlistener for the buttons
			//mainB3.addActionListener(this); 
			//mainB1.setLocation(500,500);
			mainB1.setBounds(100,400,150,50);
			mainB2.setBounds(400,400,150,50);//set the location and size of the buttons
			add(mainB1);//add mainB1
			add(mainB2);//add mainB2
			//add(mainB3);//add mainB3
		}
		public void paintComponent(Graphics g)//add paintComponent to draw images and texts
		{
			super.paintComponent(g);
			g.drawImage(bapsImage,50,50,700,300,this);//show the image of BAPS in the main panel
			g.setColor(Color.BLACK);//set to black ink
			g.drawString("Block's Area & Perimeter Simulator",100,380);//show the full name of BAPS
			g.setFont(new Font("SANS_SERIF",0,20));//set the font and size for the string
			/*if(focus3)//if button3 is pressed
			{
				cards.show(cardpanel10,"BioPanel");//the program will moved to the 10th panel
				repaint();
			}*/
		}
		/*public void mouseClicked(MouseEvent e)
		{
			int x = e.getX();
			int y = e.getY();//detect the x and y valuse of the current location of cursor
			if (x >= 200 && x<=500 && y >= 100 && y <= 200)
				focus3 = true;//if the cursor is within the area of the picture change focus3 to true
			else
				focus3 = false;//if not change to false
		}*/
		public void actionPerformed(ActionEvent e)//action event for the jbuttons
		{
			//requestFocus();
			if(e.getSource()==(mainB1))//if button1 is pressed
			{
				cards.show(BapsGame.p1,"LevelPanel");//the program will moved to the 2nd panel
				repaint();
			}
			if(e.getSource()==(mainB2))//if button2 is pressed
			{
				cards.show(BapsGame.p1,"Instructions");//the program will moved to the 9th panel
				repaint();
			}
			//if(e.getSource() == bapsImage)//if button3 is pressed
				//focus3 = true;//focus3 becomes true
		}
		/*public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}*/
	}
	public class LevelPanel extends JPanel implements ActionListener//LevelPanel class header - extend JFrame
	{
		private JButton L1button, L2button, L3button, L4button, L5button, L6button, LButton; //private buttons for each level
		public LevelPanel() 
		{ //constructor
				setLayout(null);
				LButton = new JButton("HOME");
				LButton.setBounds(800,0,100,50);
				LButton.addActionListener(this);
				add(LButton);
				L1button = new JButton("1");//initialize buttons
				L2button = new JButton("2");
				L3button = new JButton("3");
				L4button = new JButton("4");
				L5button = new JButton("5");
				L6button = new JButton("6");
				L1button.setBounds(100,100,150,150);
				L2button.setBounds(400,100,150,150);
				L3button.setBounds(700,100,150,150);
				L4button.setBounds(100,300,150,150);
				L5button.setBounds(400,300,150,150);
				L6button.setBounds(700,300,150,150);
				add(L1button); //add buttons to panel
				add(L2button);
				add(L3button);
				add(L4button);
				add(L5button);
				add(L6button);
				L1button.addActionListener(this); //make buttons clickable
				L2button.addActionListener(this);
				L3button.addActionListener(this);
				L4button.addActionListener(this);
				L5button.addActionListener(this);
				L6button.addActionListener(this);
		}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==LButton)
					cards.show(BapsGame.p1, "MainPanel");
				if(e.getSource()== L1button) //based on what level users choose, display the game that of that level
				{
					pGoal = "6";
					aGoal = "2";
					cards.show(BapsGame.p1, "PlayMode123");
					repaint();
				}
				if(e.getSource()== L2button)
				{
					pGoal = "12";
					aGoal = "6";
					cards.show(BapsGame.p1, "PlayMode123");
					repaint();
				}
				if(e.getSource()== L3button)
				{
					pGoal = "12";
					aGoal = "7";
					cards.show(BapsGame.p1, "PlayMode123");
					repaint();
				}
				if(e.getSource()== L4button)
				{
					pGoal = "16";
					aGoal = "8";
					cards.show(BapsGame.p1, "PlayMode123");
					repaint();
				}
				if(e.getSource()== L5button)
				{
					pGoal = "20";
					aGoal = "9";
					cards.show(BapsGame.p1, "PlayMode123");
					repaint();
				}
				if(e.getSource()== L6button)
				{
					pGoal = "20";
					aGoal = "10";
					cards.show(BapsGame.p1, "PlayMode123");
					repaint();
				}
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				setBackground(Color.PINK);
				g.setColor(Color.BLACK);
				g.setFont(new Font("SANS-SERIF",0,20));//set the font and size for the string
				g.drawString("Choose your level.",400,50);
			}
	}

		/*class HomeIcon extends JPanel implements ActionListener //HomeIcon class header - extends JPanel implements Action Listener
		{
			private JButton homeButton;
			HomeIcon()
			{
				setLayout(null);
				homeButton = new JButton("Home");
				homeButton.setBounds(0,0,50,50);
				add(homeButton);
			}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==homeButton)
					cards.show(BAPS.p,"MainPanel");
			}
		}*/
	public class PlayMode123 extends JPanel 
	{
		// private int areacount;
	   // private int pericount;
		Board board = new Board();
	    private int perimeter; //total perimeter of blocks in grid
	    private int areaByUser; //total area of blocks in grid //
	    private boolean correct; 
	    private boolean wrong;
	    private boolean newLevel;
	    private JButton checkbutton; //button that users use to check if their areas/perimeter match the goal
	    //JButton for checking answer(aka perimeter/area)//class LevelPanel extends JPanel{}
		public PlayMode123() 
	    {
	            setLayout(null); //set Layout as null
	            Toolkit tools = new Toolkit();//construct panels
	            Goal goal = new Goal();
	            tools.setBounds(0,50,110,590);
	            board.setBounds(110,50,890,590);
	            goal.setBounds(0,0,1000,100);
	            add(goal); //add panel that has area/perimeter goals at top
	            add(board); //add panel that users drag blocks into in the center
	            add(tools);//add panel that has various buttons to left side
	            setVisible(true); //make panel visible
	            newLevel = false;
	     }
	     public void paintComponent(Graphics g)
	     {
	     	super.paintComponent(g);
	        setBackground(Color.PINK);
	     }

	    class Toolkit extends JPanel implements ActionListener
	    {
	            private JButton home;//initialize buttons
	            private int checkcount;
	            private JButton resetb;
	            private JButton levels;
	            int option;
	            Toolkit()
	            {
	                    setLayout(null);//set layout as null
	                    home =  new JButton("HOME");
	                    levels = new JButton("LEVELS");
	                    resetb = new JButton("RESET");
	                    resetb.addActionListener(this);
	                    checkbutton = new JButton("CHECK");//instantiate button named play into mainB1
	                    checkbutton.addActionListener(this);
	                    levels.addActionListener(this);
	                    home.addActionListener(this);//make buttons clickable
	                    home.setBounds(10,10,100,50);
	                    resetb.setBounds(10,240,100,50);
	                    levels.setBounds(10,170,100,50);
	                    checkbutton.setBounds(10,310,100,50);
	                    add(home);
	                    add(resetb);
	                    add(levels);
	                    add(checkbutton);
	            }
	            public void paintComponent(Graphics g)
	            {
	                    super.paintComponent(g);
	                    setBackground(Color.PINK);

	            }

                public void actionPerformed(ActionEvent e)
                {
                	if(e.getSource()==levels)
                	{
                		cards.show(BapsGame.p1,"LevelPanel");
                		newLevel = true;
                		repaint();
                	}
                	if (e.getSource()==home)
                	{
                		cards.show(BapsGame.p1, "MainPanel");
                		newLevel = true;
                		repaint();
                	}
                	if(e.getSource()==resetb)
                	{
                		board.reset();
                		board.repaint();
                	}
                    if(e.getSource()==checkbutton)//if button1 is pressed
                    {

                    	if(perimeter == Integer.parseInt(pGoal) && areaByUser == Integer.parseInt(aGoal))
                    	{
                    		JOptionPane.showConfirmDialog(new JFrame(), "Good Job!", "Correct", JOptionPane.PLAIN_MESSAGE);
                    		cards.show(BapsGame.p1,"LevelPanel");
                    		newLevel = true;
                    	}
                    	else
                    	{
                    		 JOptionPane.showMessageDialog(new JFrame(),"Incorrect area and/or perimeter. Try Again!", "Wrong", JOptionPane.ERROR_MESSAGE);
                    	}
                    }
                }
	    }

	    class Goal extends JPanel
	    {
	            Goal()
	            {

	            }
	            public void paintComponent(Graphics g)
	            {
	                setBackground(Color.PINK);
	                g.setFont(new Font("SANS-SERIF",0,20));//set the font and size for the string
	                g.drawString("Perimeter: " + pGoal + "   Area: " + aGoal, 425,50);
	            }
	    }

	    class Board extends JPanel
	    {
	        int gridx[] = new int[13]; //array containing the values of the columns (x coordinates)
	        int gridy[] = new int[9]; //array containing the values of the rows (y coordinates)
	        // make an array to hold all of your rectangles
	        // then you can use a nested for loop to compare each rectangle with every other rectangle
	        // so then you can see how many they are next to
	        Rectangle[] leRectangles = new Rectangle[10];
	        int[] preX = new int[10]; //array containing the distance between the x coordinates of the mouse and each rect
	        int[] preY = new int[10]; //array containing the distance between the y coordinates of the mouse and each rect
	        int[] prevX = new int[10]; //array containing the x coordinates of each rect before moving 
	        int[] prevY = new int[10]; //array containing the y coordinates of each rect before moving
	        Rectangle[] area = new Rectangle[10]; //area that each rectangle is able to move in 
	        boolean[] pressOut = new boolean[10]; //tells whether or not user clicked on specific rectangle
	        boolean firstRect = true; //tells if the rectangle moved is the first rectangle or not 
	        boolean neighbor = false; //tells if the rectangle is right next to another
	        int blockCounter; //for the number of blocks in the grid
	        private Dimension dim = new Dimension(890, 590); //dimension of board, which is the area the rectangles can move in

	        public Board() 
	        {
	            addMouseMotionListener(new MyMouseAdapter());
	            addMouseListener(new MyMouseAdapter());
	            for (int i = 0; i < 10; i++) 
	            {
	                leRectangles[i] = new Rectangle(50 + 70 * i, 500, 50, 50); 
	                //initialize each rect to specific location and make them 50x50 pixels
	                pressOut[i] = false; 
	                area[i] = new Rectangle(dim); //make rectangles only able to move within dimensions of Board panel
	                prevX[i] = leRectangles[i].x; //find the x coordinate of each rectangle before it has moved
	                prevY[i] = leRectangles[i].y; //find the y coordinate of each rectangle before it has moved
	            }
	            for (int i = 0; i <= 12; i++) 
	                gridx[i] = 110 + 50*i; //add the values of the columns
	            for(int i = 0; i <= 8; i++)
	                gridy[i] = 50 + 50*i; //add the values of the rows
	        }
	        @Override
	        public Dimension getPreferredSize() {
	                return dim;
	        }

	        public void reset()
	        {
	        	for(int i = 0; i < leRectangles.length; i++)
	        	{
	        		leRectangles[i].setLocation(50 + 70 * i, 500);
	        	}
	        }
	        @Override
	        public void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                setBackground(Color.PINK);
	            g.setColor(Color.BLACK); //draw grid 
	            for (int x = 110; x<=710; x+=50)
	                    g.drawLine(x, 50, x, 450);
	            for (int y = 50; y<=450; y+=50)
	                    g.drawLine(110, y, 710, y);
	            if (newLevel)
	            {
	            	reset();
	            	newLevel = false;
	            }
	            Graphics2D g2d = (Graphics2D) g;

	            for(int i = 0; i < leRectangles.length; i++)
	                g2d.fill(leRectangles[i]); // draw rectangles
	        }

	        boolean checkRect(int i) 
	        { //boolean method that sets the rectangles to the right location 
	            if (area[i] == null) {
	                    return false; 
	            }

	            if (area[i].contains(leRectangles[i].x, leRectangles[i].y, leRectangles[i].getWidth(),leRectangles[i].getHeight())) {
	                    return true;
	            }

	            int new_x = leRectangles[i].x;
	            int new_y = leRectangles[i].y;

	            if ((leRectangles[i].x + leRectangles[i].getWidth()) > area[i].getWidth()) {
	                    new_x = (int) area[i].getWidth() - (int) (leRectangles[i].getWidth() - 1);
	            }
	            if (leRectangles[i].x < 0) {
	                    new_x = -1;
	            }
	            if ((leRectangles[i].y + leRectangles[i].getHeight()) > area[i].getHeight()) {
	                    new_y = (int) area[i].getHeight() - (int) (leRectangles[i].getHeight() -1);
	            }
	            if (leRectangles[i].y < 0) {
	                    new_y = -1;
	            }
	            leRectangles[i].setLocation(new_x, new_y);
	            return false;
	        }

	        private class MyMouseAdapter extends MouseAdapter
	        {
	            @Override
	            public void mousePressed(MouseEvent e) {
	                for(int i = 0; i < leRectangles.length; i++)
	                {
	                    prevX[i] = leRectangles[i].x; //set value to rect x coordinate
	                    prevY[i] = leRectangles[i].y; //set value to rect y coordinate

	                    preX[i] = leRectangles[i].x - e.getX(); //set value to rect x coordinate - mouse x coordinate
	                    preY[i] = leRectangles[i].y - e.getY(); //set value to rect y coordinate - mouse y coordinate

	                    if (leRectangles[i].contains(e.getX(), e.getY())) //if mouse clicked on specific rect
	                        updateLocation(e, i); //update location
	                    else
	                        pressOut[i] = true; //if mouse did not click on specific rect, then it is pressed out of the rect
	                }
	            }

	            @Override
	            public void mouseDragged(MouseEvent e) {
	                for (int i = 0; i < leRectangles.length; i++)
	                {
	                    if (!pressOut[i]) //if mouse clicked in rect
	                        updateLocation(e, i); //update location
	                }
	            }

	            @Override
	            public void mouseReleased(MouseEvent e) 
	            {
	            	perimeter = checkRectInGrid()*4; //total perimeter of all blocks 
	                for(int i = 0; i < leRectangles.length; i++)
	                {
	                    if (leRectangles[i].contains(e.getX(), e.getY())) //if mouse is in rectangle when released
	                    {
	                        updateLocation(e, i); //update location
	                        snap(i); //find coordinates to snap to absed on location
	                        //find rects that are next to each other to subtract from overall perimeter
	                        /*for (int j = 0; j < leRectangles.length; j++) 
	                        {
	                            if (i != j)
	                            {
	                                if (checkNeighbors(leRectangles[i], leRectangles[j]))
	                                {
	                                	System.out.println(perimeter);
	                                    perimeter-=2;
	                                    System.out.println(perimeter);
	                                }
	                            }
	                        }*/
	                        repaint();
	                    }
	                    else
	                        pressOut[i] = false; //if mouse is not in rect, set to false
	                }

	                for (int i = 0; i < leRectangles.length; i++)
	                {
	                	for (int j = 0; j < leRectangles.length; j++) 
                        {
                            if (i != j)
                            {
                                if (checkNeighbors(leRectangles[i], leRectangles[j]))
                                {
                                    perimeter--;
                                }
                            }
                        }
	                }
	                repaint();
	            }

	            public void updateLocation(MouseEvent e, int i) {
	                //for(int i = 0; i < leRectangles.length; i++)
	                //{
	                    leRectangles[i].setLocation(preX[i] + e.getX(), preY[i] + e.getY()); //set location
	                    checkRect(i);
	                //}
	                repaint(); //call paintComponent
	            }
	           
	        } 
	        public boolean checkNeighbors(Rectangle a, Rectangle b)
	        {
	            //if x coordinate of rect1 minus x coordinate of rect2 is exactly 50 
	            //and y coordinate of rect1 minus y coordinate of rect 2 isnt exactly 50
	                //rect1 is next to rect2
	            //if y coordinaate of rect1 minus y coordinate of rect2 is exactly 50
	            //and x coordinate of rect1 minus x coordinate of rect2 is not exactly 50
	                //rect1 is next to rect2
	            //anything else = false
	            if ((Math.abs(a.x - b.x) == 50) && (a.y == b.y))
	                return true;
	            if ((a.x == b.x) && (Math.abs(a.y - b.y) == 50))
	                return true;
	            else
	           		return false;
	        }

	        public int checkRectInGrid()
	        {
	            blockCounter = 0; //blocks in grid
	            //loop through each rect to see if it is located within coordinates of grid
	            for (int i = 0; i < leRectangles.length; i++)
	            {
	                if(leRectangles[i].x >= 110 && leRectangles[i].x <= 660 && leRectangles[i].y <= 400 && leRectangles[i].y >= 50) //if coordinates are in the grid
	                   blockCounter ++;
	                areaByUser = blockCounter; //each block has area of 1; area = # of blocks
	            }
	            return blockCounter;
	        }

	        public void snap(int i)
	        {
	                int xCenter = leRectangles[i].x+25; //x coordinate of center of rect
	                int yCenter = leRectangles[i].y+25; //y coordinate of center of rect
	                int newX = leRectangles[i].x; //initialize newX and newY to be OG points of rect
	                int newY = leRectangles[i].y;
	                //if center point is in between two specific rows/cols, then set newX/newY to specific row/col
	                //update location with newX/newY for snapping to grid effect
	                for (int x = 0; x < gridx.length-1; x++)
	                {
	                    if(xCenter>=gridx[x] && xCenter<gridx[x+1])
	                        newX = gridx[x];
	                }
	                for (int y = 0; y < gridy.length-1; y++)
	                {
	                    if(yCenter>=gridy[y] && yCenter<gridy[y+1])
	                        newY = gridy[y];
	                }
	                if (xCenter >= gridx[0] && xCenter <= gridx[gridx.length - 1])
	                {
	                    if (yCenter >= gridy[0] && yCenter <= gridy[gridy.length - 1])
	                    {
	                        leRectangles[i].setLocation(newX, newY);
	                    }
	                }
	        }
	    }
	}
	class PlayModeL2 extends JPanel{}
	class PlayModeL3 extends JPanel{}
	class PlayModeL4 extends JPanel{}
	class PlayModeL5 extends JPanel{}
	class PlayModeL6 extends JPanel{}
	class Instructions extends JPanel implements ActionListener //Instructions class header - extends JPanel implements Action Listener
	{
		private JButton homeButton2;
		Instructions()
		{
			setLayout(null);//uses custom layout to be able to change the location and size of buttons
			setBackground(Color.PINK);//select pink as background color
			homeButton2 = new JButton("HOME");
			homeButton2.setBounds(800,100,100,50);
			homeButton2.addActionListener(this);
			add(homeButton2);
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()== homeButton2)
				cards.show(BapsGame.p1,"MainPanel");
		}
		public void paintComponent(Graphics g)//add paintComponent to draw images and texts
		{
			super.paintComponent(g);
			g.setColor(Color.BLACK);//set to black ink
			g.setFont(new Font("SANS-SERIF",0,20));//set the font and size for the string
			g.drawString("Instructions",80,100);//show the full name of Instructions
			g.drawString("1. Click the play button and choose the level of difficulty", 80,200);
			g.drawString("2. When in game, drag the blocks at the bottom into the grid in the center",80,250);
			g.drawString("3.Using the blocks, make a shape with the perimeter and area shown at the top to" ,80,300);
			g.drawString("move on to the next level",80,350);
			g.drawString("4. Use the 'CHECK' button to check if your shape contains the correct area and perimeter",80,400);
			g.drawString("5. Make sure that the grid only contains one contiguous block.",80,450);
			g.drawString("5. Enjoy your game!",80,500);
		}
	}
}
	
/*	public Panel()
	{
		setLayout(new GridLayout(2,2)); 
		b = new JButton("show next card");
		b.addActionListener(this); 
		number = new CardPanel();
		add(number);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	public void actionPerformed(ActionEvent e)
	{
		cards.next(number);
		repaint();
	}*/



