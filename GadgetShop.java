import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

abstract class Gadget {
    protected String model;
    protected double price;
    protected int weight;
    protected String size;

    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    public abstract String display();
}

class Mobile extends Gadget {
    private int credit;

    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size);
        this.credit = credit;
    }

    public void makeCall(String phoneNumber, int duration) {
        // Logic for making a call
        System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
    }

    @Override
    public String display() {
        return "Mobile - Model: " + model + ", Price: " + price + ", Weight: " + weight + "g, Size: " + size + ", Credit: " + credit + " units";
    }
}

class MP3 extends Gadget {
    private int memory;

    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }

    public void downloadMusic(int size) {
        // Logic for downloading music
        System.out.println("Downloading " + size + " MB of music.");
    }

    @Override
    public String display() {
        return "MP3 - Model: " + model + ", Price: " + price + ", Weight: " + weight + "g, Size: " + size + ", Memory: " + memory + " MB";
    }
}

public class GadgetShop extends JFrame {
    private ArrayList<Gadget> gadgets;
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField, phoneNumberField, durationField, downloadSizeField, displayNumberField;
    private JTextArea outputArea;

    public GadgetShop() {
        gadgets = new ArrayList<>();
        createGUI();
    }

    private void createGUI() {
        setTitle("Gadget Shop");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(12, 2));
        getContentPane().add(panel, BorderLayout.CENTER);

        modelField = new JTextField();
        priceField = new JTextField();
        weightField = new JTextField();
        sizeField = new JTextField();
        creditField = new JTextField();
        memoryField = new JTextField();
        phoneNumberField = new JTextField();
        durationField = new JTextField();
        downloadSizeField = new JTextField();
        displayNumberField = new JTextField();
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Weight:"));
        panel.add(weightField);
        panel.add(new JLabel("Size:"));
        panel.add(sizeField);
        panel.add(new JLabel("Credit:"));
        panel.add(creditField);
        panel.add(new JLabel("Memory:"));
        panel.add(memoryField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(new JLabel("Duration:"));
        panel.add(durationField);
        panel.add(new JLabel("Download Size:"));
        panel.add(downloadSizeField);
        panel.add(new JLabel("Display Number:"));
        panel.add(displayNumberField);

        JButton addMobileButton = new JButton("Add Mobile");
        JButton addMP3Button = new JButton("Add MP3");
        JButton clearButton = new JButton("Clear");
        JButton displayAllButton = new JButton("Display All");
        JButton makeCallButton = new JButton("Make A Call");
        JButton downloadMusicButton = new JButton("Download Music");

        panel.add(addMobileButton);
        panel.add(addMP3Button);
        panel.add(clearButton);
        panel.add(displayAllButton);
        panel.add(makeCallButton);
        panel.add(downloadMusicButton);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        getContentPane().add(scrollPane, BorderLayout.SOUTH);

        addMobileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMobile();
            }
        });

        addMP3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMP3();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAll();
            }
        });

        makeCallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeCall();
            }
        });

        downloadMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadMusic();
            }
        });

        setVisible(true);
    }

    private void addMobile() {
        try {
            String model = modelField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int weight = Integer.parseInt(weightField.getText().trim());
            String size = sizeField.getText().trim();
            int credit = Integer.parseInt(creditField.getText().trim());
            gadgets.add(new Mobile(model, price, weight, size, credit));
            outputArea.append("Mobile added.\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid input for all fields.");
        }
    }

    private void addMP3() {
        try {
            String model = modelField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int weight = Integer.parseInt(weightField.getText().trim());
            String size = sizeField.getText().trim();
            int memory = Integer.parseInt(memoryField.getText().trim());
            gadgets.add(new MP3(model, price, weight, size, memory));
            outputArea.append("MP3 added.\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid input for all fields.");
        }
    }

    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
        outputArea.setText(""); // Clear output area as well
    }

    private void displayAll() {
        StringBuilder output = new StringBuilder();
        for (Gadget gadget : gadgets) {
            output.append(gadget.display()).append("\n\n");
        }
        outputArea.setText(output.toString());
    }

    private void makeCall() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText().trim());
            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                Gadget gadget = gadgets.get(displayNumber);
                if (gadget instanceof Mobile) {
                    String phoneNumber = phoneNumberField.getText().trim();
                    if (isValidPhoneNumber(phoneNumber)) {
                        int duration = Integer.parseInt(durationField.getText().trim());
                        ((Mobile) gadget).makeCall(phoneNumber, duration);
                        outputArea.append("Call made to " + phoneNumber + " for " + duration + " minutes.\n");
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid phone number.");
                        outputArea.append("Invalid phone number.\n");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Gadget at display number is not a Mobile.");
                    outputArea.append("Gadget at display number is not a Mobile.\n");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid display number.");
                outputArea.append("Invalid display number.\n");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid display number and duration.");
            outputArea.append("Enter a valid display number and duration.\n");
        }
    }

    private void downloadMusic() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText().trim());
            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                Gadget gadget = gadgets.get(displayNumber);
                if (gadget instanceof MP3) {
                    int downloadSize = Integer.parseInt(downloadSizeField.getText().trim());
                    ((MP3) gadget).downloadMusic(downloadSize);
                    outputArea.append("Music downloaded: " + downloadSize + " MB.\n");
                } else {
                    JOptionPane.showMessageDialog(this, "Gadget at display number is not an MP3.");
                    outputArea.append("Gadget at display number is not an MP3.\n");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid display number.");
                outputArea.append("Invalid display number.\n");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid display number and download size.");
            outputArea.append("Enter a valid display number and download size.\n");
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Example validation: Phone number must be non-empty and numeric
        return phoneNumber != null && !phoneNumber.trim().isEmpty() && phoneNumber.matches("\\d+");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GadgetShop().setVisible(true));
    }
}