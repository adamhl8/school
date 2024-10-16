public class Main {
  public static void main(String[] args) {
    System.out.println("==== Adam Langbert | May 21, 2023 | CMIS 242");

    Dog myDog = new Dog("Fluffy", 3);
    printDogInfo(myDog);

    myDog.setName("Max");
    myDog.setAge(5);
    printDogInfo(myDog);
  }

  static void printDogInfo(Dog dog) {
    System.out.println(dog.getName() + "'s age is: " + dog.getAge());
  }
}
