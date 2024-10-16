import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @course CMSC 315
 * @assignment Project 2
 * @description Class Main: Reads polynomials from a file and determines how they're sorted.
 * @author Adam Langbert
 * @date Sep 10, 2023
 * @java-version Java 17
 */

public class Main {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./polynomials"));
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            List<Polynomial> polynomials = new ArrayList<>();
            try (BufferedReader br =
                    new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        Polynomial polynomial = new Polynomial(line);
                        polynomials.add(polynomial);
                        System.out.println(polynomial);
                    } catch (InvalidPolynomialSyntax e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(),
                                "Invalid Polynomial Syntax", JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Comparator<Polynomial> weakComparator = (p1, p2) -> {
                Iterator<Polynomial.TermNode> p1Iterator = p1.iterator();
                Iterator<Polynomial.TermNode> p2Iterator = p2.iterator();

                while (p1Iterator.hasNext() && p2Iterator.hasNext()) {
                    Polynomial.TermNode p1Term = p1Iterator.next();
                    Polynomial.TermNode p2Term = p2Iterator.next();

                    // Compare only the exponents
                    int exponentComparison =
                            Integer.compare(p1Term.getExponent(), p2Term.getExponent());
                    if (exponentComparison != 0) {
                        return exponentComparison;
                    }
                }

                if (p1Iterator.hasNext()) {
                    return 1;
                }
                if (p2Iterator.hasNext()) {
                    return -1;
                }

                return 0;
            };


            boolean isStronglySorted = OrderedList.checkSorted(polynomials);
            boolean isWeaklySorted = OrderedList.checkSorted(polynomials, weakComparator);

            if (isStronglySorted && isWeaklySorted) {
                System.out.println(
                        "The list of polynomials is sorted according to both strong and weak order.");
            } else if (isStronglySorted) {
                System.out.println(
                        "The list of polynomials is sorted according to strong order only.");
            } else if (isWeaklySorted) {
                System.out
                        .println("The list of polynomials is sorted according to weak order only.");
            } else {
                System.out.println(
                        "The list of polynomials is not sorted according to either strong or weak order.");
            }
        }
    }
}
