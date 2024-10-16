import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @course CMSC 315
 * @assignment Project 2
 * @description Class Polynomial: Represents a polynomial where terms are a linked list.
 * @author Adam Langbert
 * @date Sep 10, 2023
 * @java-version Java 17
 */

public class Polynomial implements Iterable<Polynomial.TermNode>, Comparable<Polynomial> {
    private TermNode head;

    public Polynomial(String polynomial) throws InvalidPolynomialSyntax {
        String[] terms = polynomial.split(" ");
        if (terms.length % 2 != 0) {
            throw new InvalidPolynomialSyntax(
                    "Odd number of values. Missing coefficient or exponent value for a term.");
        }
        for (int i = 0; i < terms.length; i += 2) {
            double coefficient = Double.parseDouble(terms[i]);
            int exponent = Integer.parseInt(terms[i + 1]);
            this.append(coefficient, exponent);
        }
    }

    @Override
    public Iterator<TermNode> iterator() {
        return new Iterator<TermNode>() {
            private TermNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public TermNode next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                TermNode term = current;
                current = current.next;
                return term;
            }
        };
    }

    @Override
    public int compareTo(Polynomial that) {
        Iterator<TermNode> thisIterator = this.iterator();
        Iterator<TermNode> thatIterator = that.iterator();
        while (thisIterator.hasNext() && thatIterator.hasNext()) {
            TermNode thisTerm = thisIterator.next();
            TermNode thatTerm = thatIterator.next();
            int exponentComparison = Integer.compare(thisTerm.exponent, thatTerm.exponent);
            if (exponentComparison != 0) {
                return exponentComparison;
            }
            int coefficientComparison = Double.compare(thisTerm.coefficient, thatTerm.coefficient);
            if (coefficientComparison != 0) {
                return coefficientComparison;
            }
        }
        if (thisIterator.hasNext()) {
            return 1;
        }
        if (thatIterator.hasNext()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TermNode term : this) {
            if (term.coefficient != 0) {
                if (sb.length() > 0) {
                    sb.append(" + ");
                }
                sb.append(term.coefficient);
                if (term.exponent > 0) {
                    sb.append("x");
                    if (term.exponent > 1) {
                        sb.append("^").append(term.exponent);
                    }
                }
            }
        }
        return sb.toString();
    }

    public void append(double coefficient, int exponent) {
        if (head == null) {
            head = new TermNode(coefficient, exponent);
            return;
        }
        TermNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new TermNode(coefficient, exponent);
    }

    static class TermNode {
        private final double coefficient;
        private final int exponent;
        private TermNode next;

        private TermNode(double coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
        }

        public double getCoefficient() {
            return this.coefficient;
        }

        public int getExponent() {
            return exponent;
        }
    }
}
