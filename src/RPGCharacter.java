// คลาส RPGCharacter (ตัวละคร RPG)
public class RPGCharacter {

    // Interface สำหรับตัวละคร RPG
    interface Character {
        int attack(); // โจมตี

        void equipAccessory(Accessory accessory); // ติดตั้งอุปกรณ์เสริม

        String getStats(); // ดูข้อมูลสถิติของตัวละคร

        boolean isAlive(); // ตรวจสอบว่ายังมีชีวิตอยู่หรือไม่

        void takeDamage(int damage); // รับความเสียหาย

        void setName(String name); // ตั้งชื่อ

        void levelUp();
    }

    // Interface สำหรับอุปกรณ์เสริม
    interface Accessory {
        void applyEffect(Character character); // ใช้ผลของอุปกรณ์เสริม

        String getName(); // ชื่อของอุปกรณ์เสริม
    }

    // คลาส Warrior (นักรบ)
    public class Warrior implements Character {
        private String name;         // ชื่อของนักรบ
        private int baseAttack = 50; // พลังโจมตีพื้นฐาน
        private int defense = 20;    // ค่าป้องกัน
        private int HP = 100;        // พลังชีวิต
        private int level = 1;       // เลเวลเริ่มต้น
        private Accessory accessory; // อุปกรณ์เสริม



        @Override
        public int attack() {
            return baseAttack;
        }

        @Override
        public void equipAccessory(Accessory accessory) {
            this.accessory = accessory;
            accessory.applyEffect(this); // ใช้ผลของอุปกรณ์เสริม
        }

        public void increaseDefense(int amount) {
            this.defense += amount; // เพิ่มค่าป้องกัน
        }

        public void levelUp() {
            level++;
            baseAttack += 10;
            defense += 5;
            HP += 20;
        }

        @Override
        public boolean isAlive() {
            return HP > 0;
        }

        @Override
        public void takeDamage(int damage) {
            int reducedDamage = Math.max(0, damage - defense);
            HP -= reducedDamage;
            if (HP < 0) HP = 0;
        }

        @Override
        public String getStats() {
            return name + " [Level: " + level + ", HP: " + HP + ", Attack: " + baseAttack +
                    ", Defense: " + defense + (accessory != null ? ", Accessory: " + accessory.getName() : "") + "]";
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }
    }

    // คลาส Mage (จอมเวท)
    public class Mage implements Character {
        private String name;
        private int baseAttack = 70; // พลังโจมตีพื้นฐาน
        private int mana = 100;      // มานาเริ่มต้น
        private int HP = 80;         // พลังชีวิต
        private int level = 1;       // เลเวลเริ่มต้น
        private Accessory accessory; // อุปกรณ์เสริม

        public Mage(String name) {
            this.name = name; // กำหนดชื่อ
        }

        @Override
        public int attack() {
            return baseAttack;
        }

        @Override
        public void equipAccessory(Accessory accessory) {
            this.accessory = accessory;
            accessory.applyEffect(this); // ใช้ผลของอุปกรณ์เสริม
        }

        public void increaseMana(int amount) {
            this.mana += amount; // เพิ่มค่ามานา
        }

        public void levelUp() {
            level++;
            baseAttack += 15;
            mana += 30;
            HP += 15;
        }

        @Override
        public boolean isAlive() {
            return HP > 0;
        }

        @Override
        public void takeDamage(int damage) {
            HP -= damage;
            if (HP < 0) HP = 0;
        }

        @Override
        public String getStats() {
            return name + " [Level: " + level + ", HP: " + HP + ", Attack: " + baseAttack +
                    ", Mana: " + mana + (accessory != null ? ", Accessory: " + accessory.getName() : "") + "]";
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }
    }

    // คลาส Shield (อุปกรณ์เสริมสำหรับ Warrior)
    public class Shield implements Accessory {
        private final String name = "Shield";

        @Override
        public void applyEffect(Character character) {
            if (character instanceof Warrior) {
                ((Warrior) character).increaseDefense(10);
            }
        }

        @Override
        public String getName() {
            return name;
        }
    }

    // คลาส Magic Amulet (อุปกรณ์เสริมสำหรับ Mage)
    public class MagicAmulet implements Accessory {
        private final String name = "Magic Amulet";

        @Override
        public void applyEffect(Character character) {
            if (character instanceof Mage) {
                ((Mage) character).increaseMana(50);
            }
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
