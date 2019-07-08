import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
 
 
public class Chess extends JFrame{
 
	public static final int width=600;
	JLabel lMessage=new JLabel("");
	JButton[][] buttons=new JButton[3][3];
	
	public static void main(String[] args){
		Chess chess=new Chess();
	}
	
	public Chess(){
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				buttons[i][j]=new JButton();
				buttons[i][j].addMouseListener(new mouseListener());
				panel.add(buttons[i][j]);
			}
		}
		this.setLayout(new GridLayout(2, 1));
		this.add(panel);
		this.add(lMessage);
		
		this.pack();
		this.setVisible(true);
		this.setSize(new Dimension(width, width));
	}
	
	class mouseListener implements MouseListener{
 
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button=(JButton)e.getSource();
			if(!button.getText().equals("")){
				return;
			}
			int code=e.getButton();
			if(code==e.BUTTON1){
				button.setText("o");
			}else if(code==e.BUTTON2){
				button.setText("x");
			}else{
				button.setText("x");
			}
			isWin();
		}
 
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
 
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
 
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
 
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		boolean isWin(){
			//check every lines
			for(int i=0;i<3;i++){
				String a=buttons[i][0].getText();
				String b=buttons[i][1].getText();
				String c=buttons[i][2].getText();
			}
			//check every rows
			for(int i=0;i<3;i++){
				String a=buttons[0][i].getText();
				String b=buttons[1][i].getText();
				String c=buttons[2][i].getText();
				publicPartOfIsWin(a,b,c);
			}
			//check slant
			String a=buttons[0][0].getText();
			String b=buttons[1][1].getText();
			String c=buttons[2][2].getText();
			publicPartOfIsWin(a,b,c);
			
			a=buttons[0][2].getText();
			b=buttons[1][1].getText();
			c=buttons[2][0].getText();
			publicPartOfIsWin(a,b,c);
			return false;
		}
		
	    boolean publicPartOfIsWin(String a,String b,String c)
		{
			if(!a.equals("")&&a.equals(b)&&a.equals(c)){
				if(a.equals("o")){
					lMessage.setText("left button is victory.");
					return true;
				}else{
					lMessage.setText("right button is victory.");
					return true;
				}
			}
			return false;
		}
	}
}