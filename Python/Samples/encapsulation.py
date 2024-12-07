
class Character:
    def __init__(self):
        self._health = 100

    @property
    def health(self):
        return self._health

    @health.setter
    def health(self, value):
        if value < 0:
            self._health = 0
        else:
            self._health = value



if __name__ == "__main__":
    hero = Character()
    print(f"Initial Health: {hero.health}")  # Access health via getter

    hero.health -= 50  # Modify health via setter
    print(f"After Damage: {hero.health}")

    hero.health -= 100  # Health cannot drop below 0
    print(f"After Heavy Damage: {hero.health}")