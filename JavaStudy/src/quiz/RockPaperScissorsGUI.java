package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsGUI extends JFrame {

	private ImageIcon[] images = {
		new ImageIcon(getClass().getResource("/aaa/scissors.png")),
		new ImageIcon(getClass().getResource("/aaa/rock.png")),
		new ImageIcon(getClass().getResource("/aaa/paper.png")),
	};
	private JLabel userChoiceLabel = new JLabel("사용자 선택");
	private JLabel computerChoiceLabel = new JLabel("컴퓨터 선택");
	private JLabel resultLabel = new JLabel("결과: ");
	
	private int userChoice;
	
	public RockPaperScissorsGUI() {
		setTitle("가위바위보 게임");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//타이틀
		JLabel titleLabel = new JLabel("가위바위보를 선택하세요");
		add(titleLabel);
		
		//버튼 생성
		JButton scissorsButton = new JButton("가위");
		JButton rockButton = new JButton("바위");
		JButton paperButton = new JButton("보");
		
        // 버튼에 ActionListener 추가
        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame(1);  // 가위 선택
            }
        });
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame(2);  // 바위 선택
            }
        });
        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame(3);  // 보 선택
            }
        });
        
        add(scissorsButton);
        add(rockButton);
        add(paperButton);

        add(userChoiceLabel);
        add(computerChoiceLabel);
        add(resultLabel);
		
		setVisible(true);
	}
	
    // 게임 로직을 처리하는 메서드
    private void playGame(int userChoice) {
        this.userChoice = userChoice;
        
        // 컴퓨터의 선택을 랜덤으로 생성
        int computerChoice = (int) (Math.random() * 3) + 1;
        
        // 사용자와 컴퓨터의 선택을 레이블에 업데이트
        userChoiceLabel.setText("사용자 선택: " + getChoiceName(userChoice));
        computerChoiceLabel.setText("컴퓨터 선택: " + getChoiceName(computerChoice));
        
        // 결과 처리
        String result = getResult(userChoice, computerChoice);
        resultLabel.setText("결과: " + result);
    }
    
    // 선택 번호를 문자열로 변환하는 메서드
    private String getChoiceName(int choice) {
        switch (choice) {
            case 1: return "가위";
            case 2: return "바위";
            case 3: return "보";
            default: return "";
        }
    }
    
    // 게임 결과를 계산하는 메서드
    private String getResult(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return "비겼습니다.";
        } else if ((userChoice == 1 && computerChoice == 3) ||
                   (userChoice == 2 && computerChoice == 1) ||
                   (userChoice == 3 && computerChoice == 2)) {
            return "이겼습니다!";
        } else {
            return "졌습니다...";
        }
    }
	
	public static void main(String[] args) {
		
		new RockPaperScissorsGUI();
		
	}
}
