public class Main {
  public static void main(String[] args) {
    System.out.println("==== Adam Langbert | May 24, 2023 | CMIS 242 ====\n");

    Dog myDog = new Dog("Fluffy", 3, 50);
    printDogInfo(myDog);

    myDog.setName("Max");
    myDog.setAge(5);
    myDog.setWeight(75);
    printDogInfo(myDog);
  }

  static void printDogInfo(Dog dog) {
    String dogInfo = """
        %s:
        - Age: %s
        - Weight: %s
        """;

    System.out.println(String.format(dogInfo, dog.getName(), dog.getAge(), dog.getWeight()));
  }
}
