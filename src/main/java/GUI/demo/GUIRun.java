package GUI.demo;


import lombok.SneakyThrows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GUIRun extends JFrame {
    /**
     * 用户名
     */
    private JTextField usernameField;

    /**
     * 密码
     */
    private JPasswordField passwordField;

    /**
     * 密码显示按钮
     */
    private JCheckBox showPasswordCheckBox;

    /**
     * 文本输入
     */
    private JTextField textField;

    /**
     * 下拉框
     */
    private JComboBox<String> comboBox;

    /**
     * 偏好设置,用于保存数据
     */
    private Preferences preferences;


    public GUIRun() {
        // 初始化偏好设置（用于存储用户名和密码）
        preferences = Preferences.userRoot().node(this.getClass().getName());
        // 设置窗口大小
        setTitle("XXX-copyright 1.0");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 居中显示
        setLocationRelativeTo(null);

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 创建表单面板
        JPanel titlePanel = createTitlePanel();
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // 创建用户输入面板
        JPanel formPanel = createUserFormPanel();
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // 创建按钮,添加事件
        JPanel buttonPanel = createButton();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 添加主面板到窗口
        add(mainPanel);
        // 设置窗口可见
        setVisible(true);

        // 加载保存的用户名和密码
        loadCredentials();
    }

    /**
     * 标题面板
     */
    private JPanel createTitlePanel() {
        // 创建标题面板
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        titlePanel.setBackground(new Color(240, 240, 240));
        // 标题标签
        JLabel titleLabel = new JLabel("配置中心工具", JLabel.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        titleLabel.setForeground(new Color(70, 130, 180));
        // titleLabel.setForeground(new Color(0, 102, 204));
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        // 帮助按钮（问号图标）
        JButton helpButton = new JButton("?");
        helpButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        helpButton.setPreferredSize(new Dimension(30, 30));
        helpButton.setMargin(new Insets(0, 0, 0, 0));
        helpButton.setToolTipText("<html><body style='width: 200px;'>" +
                "<b>登录系统使用说明:</b><br>" +
                "1. xxxxxxxxxx</body></html>");
        titlePanel.add(helpButton, BorderLayout.EAST);
        return titlePanel;
    }

    /**
     * 创建表单面板
     */
    private JPanel createUserFormPanel() {
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 15));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JLabel usernameLabel = new JLabel("账号:");
        usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JPanel passwordPanel = new JPanel(new BorderLayout());
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        // 显示密码复选框
        showPasswordCheckBox = new JCheckBox("显示");
        showPasswordCheckBox.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        // 密码支持展示和隐藏
        showPasswordCheckBox.addActionListener(e -> togglePasswordVisibility());
        passwordPanel.add(passwordField, BorderLayout.CENTER);
        passwordPanel.add(showPasswordCheckBox, BorderLayout.EAST);

        JLabel textLabel = new JLabel("配置中心appId");
        textLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JPanel textFieldPanel = new JPanel(new BorderLayout());
        textField = new JTextField();
        textFieldPanel.add(textField, BorderLayout.CENTER);

        // 下拉框
        JLabel comboBoxLabel = new JLabel("环境:");
        comboBoxLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        String[] options = {"BETA", "PERF", "PRD"};
        comboBox = new JComboBox<>(options);

        formPanel.add(usernameLabel);
        formPanel.add(usernameField);

        formPanel.add(passwordLabel);
        formPanel.add(passwordPanel);
        formPanel.add(textLabel);
        formPanel.add(textFieldPanel);
        formPanel.add(comboBoxLabel);
        formPanel.add(comboBox);
        return formPanel;
    }


    /**
     * 创建按钮
     */
    private JPanel createButton() {
        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        JButton confirmButton = new JButton("确认");
        JButton clearButton = new JButton("重置");

        // 设置按钮样式
        confirmButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        confirmButton.setBackground(new Color(0, 153, 204));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFocusPainted(false);

        clearButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        clearButton.setBackground(new Color(204, 102, 0));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);

        // 添加按钮事件监听器
        confirmButton.addActionListener(new ActionListener() {
            @Override
            @SneakyThrows
            public void actionPerformed(ActionEvent e) {
                // 处理逻辑
                process();
            }
        });

        // 重置操作
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
                textField.setText("");
                comboBox.setSelectedIndex(0);
            }
        });

        buttonPanel.add(confirmButton);
        buttonPanel.add(clearButton);
        return buttonPanel;
    }

    // 保存用户名和密码
    private void saveCredentials(String username, String password) {
        preferences.put("username", username);
        preferences.put("password", password);
    }

    // 加载保存的用户名和密码
    private void loadCredentials() {
        String username = preferences.get("username", "");
        String password = preferences.get("password", "");

        usernameField.setText(username);
        passwordField.setText(password);
    }

    // 切换密码可见性
    private void togglePasswordVisibility() {
        if (showPasswordCheckBox.isSelected()) {
            passwordField.setEchoChar((char) 0); // 显示密码
        } else {
            passwordField.setEchoChar('•'); // 隐藏密码
        }
    }

    private void process() throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String text = textField.getText().trim();
        String selectedOption = (String) comboBox.getSelectedItem();

        // 验证输入
        if (username.isEmpty() || password.isEmpty() || text.isEmpty() || selectedOption.isEmpty()) {
            // 弹框提示
            JOptionPane.showMessageDialog(this, "填写内容不允许为空", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 保存输入信息
        saveCredentials(username, password);

        // 弹框显示处理结果
        JOptionPane.showMessageDialog(this, "处理完成,文件路径:", "结果", JOptionPane.INFORMATION_MESSAGE);
    }


    public static void main(String[] args) {
        // 使用 SwingUtilities 确保GUI线程安全
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIRun();
            }
        });
    }
}