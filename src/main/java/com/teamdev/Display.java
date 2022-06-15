package com.teamdev;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.json.simple.parser.ParseException;

public class Display extends JFrame implements MouseListener {

    KakaoAPI kakaoAPI = new KakaoAPI();
    DataLoader dataLoader = new DataLoader();
    DBConnecter dbConnecter = new DBConnecter();

    public String selectedDo = "";
    public String selectedDoCode = "";
    public String selectedSi = "";
    public String location;
    public String campType;
    public String performType;
    public String searchWord;

    String mapX = "";
    String mapY = "";

    JLabel locationInput = new JLabel();
    JLabel Result = new JLabel();
    JLabel logoLabel = new JLabel();
    JTextField textField = new JTextField();
    JButton button = new JButton();
    JButton camp = new JButton();
    JButton perform = new JButton();
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;

    ImageIcon icon = new ImageIcon("res/grass.png");
    ImageIcon logo = new ImageIcon("res/camp.png");

    JPanel jPanel = new JPanel();
    JPanel jPanel2 = new JPanel();
    JPanel search = new JPanel();
    JPanel typePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel resultPanel = new JPanel();
    JPanel mapPanel = new JPanel(){
        public void paintComponent(Graphics g){
            g.drawImage(icon.getImage(), 0, -70, null);
        }
    };
    JPanel mainPanel = new JPanel();

    String[] doName = dbConnecter.read_Do();
    JComboBox<String> doNameComboBox = new JComboBox<String>(doName);

    String[] doCodeList = dbConnecter.read_DoCode();

    List<String>[] siNameList = dbConnecter.read_Si();
    JComboBox<String> siNameComboBox = new JComboBox<String>();

    String[] type = dataLoader.getType();
    String[] type_perform = dataLoader.getPerformType();
    JComboBox<String> typeComboBox = new JComboBox<String>(type);

    ListTest listTest = new ListTest(this);

    String[] header = null;

    // JScrollPane pane1;
    // JScrollPane pane2;

    public int frameWidth = 1500;
    public int frameHeight = 1200;
    public String performId;
    public String fcltyID;

    public Display() {
        // UIManager.put("ComboBoxUI", "com.alee.laf.combobox.WebComboBoxUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(frameWidth, frameHeight);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        // googleMaps.setting();
        // googleMaps.display();

        listener();

        getSetting();
        tableSetting();

        jPanel.add(doNameComboBox);
        jPanel.add(siNameComboBox);

        search.add(textField);
        typePanel.add(typeComboBox);
        typePanel.add(camp);
        typePanel.add(perform);

        buttonPanel.add(button);

        resultPanel.add(scrollPane);

        jPanel2.add(logoLabel);
        jPanel2.add(jPanel);
        jPanel2.add(search);
        jPanel2.add(typePanel);
        jPanel2.add(buttonPanel);

        mapPanel.setPreferredSize(new Dimension(500, 500));
        mapPanel.add(new GoogleMaps("", ""));
        mapPanel.setBackground(Color.WHITE);

        getContentPane().add(BorderLayout.EAST, resultPanel);
        getContentPane().add(BorderLayout.WEST, jPanel2);
        getContentPane().add(BorderLayout.SOUTH, mapPanel);
        setVisible(true);
        pack();
    }

    public void tableSetting() {

        header = new String[] { "시설명", "업종", "전화번호", "주소" };
        model = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table = new JTable(model);
        table.setOpaque(true);
        table.setBackground(Color.WHITE);
        table.setAutoCreateRowSorter(true);
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(this);
        table.setRowHeight(30);
        Font font = new Font("돋음", Font.PLAIN, 14);
        table.setFont(font);
        
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.white);
        tableHeader.setForeground(Color.black);
        Font headerFont = new Font("돋음", Font.PLAIN, 20);
        tableHeader.setFont(headerFont);    
        // table.setFont(new Font("돋음", Font.BOLD, 20));

        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setPreferredSize(new Dimension(700, 300));
    }

    public void getSetting() {

        jPanel.setBackground(Color.WHITE);
        jPanel.setLayout(new FlowLayout());

        search.setBackground(Color.WHITE);
        search.setLayout(new FlowLayout());

        typePanel.setBackground(Color.WHITE);
        typePanel.setLayout(new FlowLayout());

        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout());

        resultPanel.setBackground(Color.WHITE);

        jPanel2.setBackground(Color.WHITE);
        jPanel2.setLayout(new GridLayout(5, 1, 20, 10));

        // 도 카테고리
        doNameComboBox.setPreferredSize(new Dimension(200, 40));
        doNameComboBox.setBackground(Color.WHITE);
        doNameComboBox.setFont(new Font("돋음", Font.BOLD, 20));

        // 시 카테고리
        siNameComboBox.setPreferredSize(new Dimension(200, 40));
        siNameComboBox.setBackground(Color.WHITE);
        siNameComboBox.setFont(new Font("돋음", Font.BOLD, 20));
        siNameComboBox.addItem(siNameList[0].get(0));

        // 타입 카테고리
        typeComboBox.setPreferredSize(new Dimension(200, 40));
        typeComboBox.setBackground(Color.WHITE);
        typeComboBox.setFont(new Font("돋음", Font.BOLD, 20));

        // 검색필드
        textField.setPreferredSize(new Dimension(400, 40));
        textField.setBackground(Color.WHITE);
        textField.setText("검색");
        textField.setFont(new Font("돋음", Font.ITALIC, 20));
        textField.setForeground(Color.gray);

        // 검색 버튼
        button.setPreferredSize(new Dimension(80, 40));
        button.setBackground(Color.WHITE);
        button.setText("검색");
        button.setFont(new Font("돋음", Font.BOLD, 20));

        camp.setPreferredSize(new Dimension(80, 40));
        camp.setBackground(Color.green);
        camp.setText("캠핑");
        camp.setFont(new Font("돋음", Font.BOLD, 20));

        perform.setPreferredSize(new Dimension(80, 40));
        perform.setBackground(Color.WHITE);
        perform.setText("공연");
        perform.setFont(new Font("돋음", Font.BOLD, 20));

        Image image = logo.getImage();
        Image newimg = image.getScaledInstance(360, 90,  java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(newimg);
        logoLabel.setPreferredSize(new Dimension(400, 40));
        logoLabel.setIcon(logo);

        Result.setHorizontalAlignment(JLabel.CENTER);
        Result.setFont(new Font("돋음", Font.BOLD, 20));
        locationInput.setHorizontalAlignment(JLabel.CENTER);
        locationInput.setFont(new Font("돋음", Font.BOLD, 20));
    }

    public void tableLoad_Camp() {
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        System.out.println("************" + listTest.cd_item.size());
        for (int i = 0; i < listTest.cd_item.size(); i++) {
            Object[] rowData = new Object[4];
            rowData[0] = listTest.cd_item.get(i).getFacltNm();
            rowData[1] = listTest.cd_item.get(i).getType();
            rowData[2] = listTest.cd_item.get(i).getTel();
            rowData[3] = listTest.cd_item.get(i).getAddr1();
            model.addRow(rowData);
        }
        table.setModel(model);

    }

    public void tableLoad_Perform() {
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        System.out.println("************" + listTest.pd_item.size());
        for (int i = 0; i < listTest.pd_item.size(); i++) {
            Object[] rowData = new Object[4];
            rowData[0] = listTest.pd_item.get(i).getPerfromNm();
            rowData[1] = listTest.pd_item.get(i).getType();
            rowData[2] = listTest.pd_item.get(i).getfcltynm();
            rowData[3] = listTest.pd_item.get(i).getPrfstate();
            model.addRow(rowData);
        }
        table.setModel(model);

    }

    public void listener() {
        camp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (camp.getBackground().equals(Color.green)) {
                    camp.setBackground(Color.white);
                    perform.setBackground(Color.green);
                    typeComboBox.setModel(new JComboBox<String>(type_perform).getModel());

                    header = new String[] { "공연명", "공연장르", "공연장소", "공연상태" };
                    model = new DefaultTableModel(header, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table.setModel(model);
                } else {
                    camp.setBackground(Color.green);
                    perform.setBackground(Color.white);
                    typeComboBox.setModel(new JComboBox<String>(type).getModel());

                    header = new String[] { "시설명", "업종", "전화번호", "주소" };
                    model = new DefaultTableModel(header, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table.setModel(model);

                }

            }

        });

        perform.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (perform.getBackground().equals(Color.green)) {
                    perform.setBackground(Color.white);
                    camp.setBackground(Color.green);
                    typeComboBox.setModel(new JComboBox<String>(type).getModel());

                    header = new String[] { "시설명", "업종", "전화번호", "주소" };
                    model = new DefaultTableModel(header, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table.setModel(model);


                } else {
                    perform.setBackground(Color.green);
                    camp.setBackground(Color.white);
                    typeComboBox.setModel(new JComboBox<String>(type_perform).getModel());

                    header = new String[] { "공연명", "공연장르", "공연장소", "공연상태" };
                    model = new DefaultTableModel(header, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table.setModel(model);

                }

            }

        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDo = doNameComboBox.getSelectedItem().toString();
                selectedSi = siNameComboBox.getSelectedItem().toString();

                // 전체 시군구 선택 시 값 ''
                if (selectedSi.equals("전체/시/군")) {
                    selectedSi = "";
                }

                // listTest.campList.removeAll();
                // listTest.performList.removeAll();
                try {
                    location = selectedDo + " " + selectedSi;
                    if (textField.getText().equals("") || textField.getText().equals("검색")) {
                        searchWord = "없음";
                    } else {
                        searchWord = textField.getText();
                    }

                    if(camp.getBackground().equals(Color.green)){
                        campType = typeComboBox.getSelectedItem().toString();
    
                        // 전체 도 선택 시, 위도 경도 0
                        if (selectedDo.equals("전체/도")) {
                            listTest.xy = new String[2];
                            listTest.xy[0] = "0";
                            listTest.xy[1] = "0";
                            listTest.dataLoad_Camp();
                            tableLoad_Camp();
    
                        } else {
                            listTest.xy = kakaoAPI.getPosition(location);
                            listTest.dataLoad_Camp();
                            tableLoad_Camp();
                        }
                    }

                    else if(perform.getBackground().equals(Color.green)){
                        performType = typeComboBox.getSelectedItem().toString();
                        if (selectedDo.equals("전체/도")) {
                            selectedDoCode = "0";
                            listTest.dateLoad_Perform();
                            tableLoad_Perform();
    
                        } else {
                            listTest.xy = kakaoAPI.getPosition(location);
                            listTest.dateLoad_Perform();
                            tableLoad_Perform();
                        }
                    }

                    // 결과 테스트
                    // Result.setText("<html>" +
                    //         "동경: " + listTest.xy[0] +
                    //         "<br>" + "북위: " + listTest.xy[1] +
                    //         "<br>" +
                    //         "<br>" + "검색어: " + searchWord +
                    //         "<br>" + "지역: " + location + " " + selectedDoCode +
                    //         "<br>" + "카테고리: " + campType +
                    //         "</html>");
                    // listTest.repaint();

                } catch (IOException | ParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        });

        doNameComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                siNameComboBox.removeAllItems();
                int doNameIndex = doNameComboBox.getSelectedIndex();
                for (int i = 0; i < siNameList[doNameIndex].size(); i++) {
                    siNameComboBox.addItem(siNameList[doNameIndex].get(i));
                }
                selectedDoCode = doCodeList[doNameIndex];
            }
        });

        siNameComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                textField.setText(null);
                textField.setFont(new Font("돋음", Font.BOLD, 20));
                textField.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub

            }

        });

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int rowIndex = table.getSelectedRow();
        int convertedRow = table.convertRowIndexToModel(rowIndex);

        if (e.getClickCount() == 2) {
            if(camp.getBackground().equals(Color.green)){
            mapY = listTest.cd_item.get(convertedRow).getMapX();
            mapX = listTest.cd_item.get(convertedRow).getMapY();

            mapPanel.removeAll();
            mapPanel.add(new GoogleMaps(mapX, mapY));
            mapPanel.revalidate();
            mapPanel.repaint();

            // GoogleMaps googleMaps = new GoogleMaps(mapY, mapX);
            }
            else {

                
                performId = listTest.pd_item.get(convertedRow).getPerformID();
                listTest.dateLoad_PerformInfo();                

                fcltyID = listTest.pdinfo_item.get(0).getFcltyID();
                listTest.dateLoad_PerformPos();
                mapX = listTest.pdpos_item.get(0).getLa();
                mapY = listTest.pdpos_item.get(0).getLo();


            mapPanel.removeAll();
            mapPanel.add(new GoogleMaps(mapX, mapY));
            mapPanel.revalidate();
            mapPanel.repaint();
            
                showPoster(listTest.pdinfo_item.get(0).getPoster());

            }


        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void showPoster(String poster) {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    String path = poster;
                    System.out.println("Get Image from " + path);
                    URL url = new URL(path);
                    BufferedImage image = ImageIO.read(url);
                    System.out.println("Load image into frame...");
                    JLabel label = new JLabel(new ImageIcon(image));
                    JFrame f = new JFrame();
                    f.setTitle("포스터");
                    f.getContentPane().add(label);
                    f.pack();
                    f.setLocation(1300, 200);
                    f.setVisible(true);
                } catch (Exception exp) {
                    exp.printStackTrace();
                }

    }

}
