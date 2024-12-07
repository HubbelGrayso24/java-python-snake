class Animal:
    def __init__(self, name):
        self.name = name

    def speak(self):
        return f"{self.name} makes a noise."


class Dog(Animal):
    def speak(self):
        return f"{self.name} barks."


class Cat(Animal):
    def speak(self):
        return f"{self.name} meows."

if __name__ == "__main__":
    animals = [Dog("Buddy"), Cat("Whiskers"), Animal("Unknown")]

    for animal in animals:
        print(animal.speak())  # Demonstrates inheritance and overriding