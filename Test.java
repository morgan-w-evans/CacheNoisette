public class TestBall {
    public static void main(String[] args) {
        new TestBall();
    }

    public TestBall() {

        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(new MyBall(30,30,10));
        frame.pack();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class MyBall extends JComponent
{
    private static final long serialVersionUID = 1L;
    public MyBall() { }
    public MyBall(int x, int y, int diameter)
    {
        super();
        this.setLocation(x, y);
        this.setSize(diameter, diameter);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColour(Colour.red);
        g.fillOval(0, 0, 100, 100);
    }
}