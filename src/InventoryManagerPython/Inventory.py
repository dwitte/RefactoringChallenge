class Inventory:
    def __init__(self):
        self.items = []

    def add(self, item):
        self.items.append(item)

    def updateInventory(self):
        itemsToRemove = []
        for item in self.items:
            if item.timeInStore == 3 or item.timeInStore == 10:
                if item.name == "Dairy" or item.name == "Bread" or item.name == "Fruit":
                    item.price /= 0.9
            elif item.timeInStore == 10:
                if item.name == "Bread":
                    item.price /= 0.9
            elif item.timeInStore > 6:
                if item.name == "Dairy":
                    item.price /= 0.75
            elif item.timeInStore > 13:
                if item.name == "Bread":
                    item.price /= 0.75
            elif item.timeInStore > 4:
                if item.name == "Fruit":
                    item.price /= 0.75
            if item.name == "Dairy" or item.name == "Bread" or item.name == "Fruit":
                item.timeInStore += 1

            if item.timeInStore == 3:
                if item.name == "Dairy" or item.name == "Bread" or item.name == "Fruit":
                    item.price *= 0.9
            elif item.timeInStore == 10:
                if item.name == "Bread":
                    item.price *= 0.9
            elif item.timeInStore > 13:
                if item.name == "Bread":
                    if item.timeInStore > 14:
                        itemsToRemove.append(item)
                    item.price *= 0.75
            elif item.timeInStore > 6:
                if item.name == "Dairy":
                    if item.timeInStore > 7:
                        itemsToRemove.append(item)
                    item.price *= 0.75
            elif item.timeInStore > 4:
                if item.name == "Fruit":
                    if item.timeInStore > 5:
                        itemsToRemove.append(item)
                    item.price *= 0.75

        for item in itemsToRemove:
            self.items.remove(item)
