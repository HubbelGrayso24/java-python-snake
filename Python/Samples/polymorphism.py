class Shape:
    def area(self):
        """Method to calculate area (to be overridden)."""
        raise NotImplementedError("Subclasses must implement this method.")

    def perimeter(self):
        """Method to calculate perimeter (to be overridden)."""
        raise NotImplementedError("Subclasses must implement this method.")


class Rectangle(Shape):
    """Rectangle class inheriting from Shape."""
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def area(self):
        return self.width * self.height

    def perimeter(self):
        return 2 * (self.width + self.height)


class Circle(Shape):
    """Circle class inheriting from Shape."""
    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return 3.14 * self.radius ** 2

    def perimeter(self):
        return 2 * 3.14 * self.radius



if __name__ == "__main__":
    shapes = [Rectangle(4, 5), Circle(3)]

    for shape in shapes:
        print(f"Shape: {shape.__class__.__name__}")
        print(f"Area: {shape.area()}")
        print(f"Perimeter: {shape.perimeter()}")
        print()