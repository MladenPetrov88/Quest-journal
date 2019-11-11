import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        List<String> words = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            words.add(input[i]);
        }

        String command = scanner.nextLine();

        while (!command.equals("Retire!")) {
            String[] temp = command.split(" - ");
            String firstCommand = temp[0];

            if (firstCommand.equals("Start")) {
                if (!words.contains(temp[1])) {
                    words.add(temp[1]);
                }
            }

             if (firstCommand.equals("Complete")) {
                if (words.contains(temp[1])) {
                    words.remove(temp[1]);
                }
            }

             if (firstCommand.equals("Side Quest")) {
                String[] sideQuest = temp[1].split(":");
                String first = sideQuest[0];
                String second = sideQuest[1];
                if (words.contains(first)){
                    if (!words.contains(second)){
                        words.add(words.indexOf(first),second);
                        words.remove(first);
                        words.add(words.indexOf(second),first);
                    }
                }
            }

             if (firstCommand.equals("Renew")) {
                if (words.contains(temp[1])) {
                    words.remove(temp[1]);
                    words.add(temp[1]);
                }
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < words.size() - 1; i++) {
            System.out.print(words.get(i) + ", ");
        }
        System.out.print(words.get(words.size() -1));

    }
}
