public class lab05 {

    public static void main(String[] args) {
        // สร้างตัวละครและตั้งชื่อ
        RPGCharacter.Character warrior1 = new RPGCharacter().new Warrior();
        RPGCharacter.Character mage = new RPGCharacter().new Mage("Gandalf");
        RPGCharacter.Character warrior2 = new RPGCharacter().new Warrior();


        // สร้างอุปกรณ์เสริม
        RPGCharacter.Accessory shield = new RPGCharacter().new Shield();
        RPGCharacter.Accessory magicAmulet = new RPGCharacter().new MagicAmulet();

        // แสดงข้อมูลก่อนติดตั้งอุปกรณ์เสริม
        System.out.println("ก่อนติดตั้งอุปกรณ์เสริม:");
        System.out.println(warrior1.getStats());
        System.out.println(mage.getStats());

        // ติดตั้งอุปกรณ์เสริม
        warrior1.equipAccessory(shield);
        mage.equipAccessory(magicAmulet);

        System.out.println("\nหลังติดตั้งอุปกรณ์เสริม:");
        System.out.println(warrior1.getStats());
        System.out.println(mage.getStats());

        // จำลองการโจมตี
        System.out.println("\nจำลองการต่อสู้:");
        fight(warrior1, mage);

        System.out.println(warrior1.getStats());
        System.out.println(mage.getStats());

        // ตรวจสอบว่ายังมีชีวิตอยู่หรือไม่
        System.out.println("\nWarrior ยังมีชีวิตอยู่หรือไม่: " + warrior1.isAlive());
        System.out.println("Mage ยังมีชีวิตอยู่หรือไม่: " + mage.isAlive());

        // เปลี่ยนชื่อให้กับตัวละคร
        warrior2.setName("Legolas");  // เปลี่ยนชื่อของ warrior เป็น "Legolas"
        System.out.println("หลังจากเปลี่ยนชื่อ:");
        System.out.println(warrior2.getStats());
        warrior1.setName("Butterfly");
        warrior1.levelUp();
        System.out.println(warrior1.getStats());
    }

    // สำหรับการต่อสู้
    public static void fight(RPGCharacter.Character attacker, RPGCharacter.Character defender) {
        int damage = attacker.attack(); // พลังโจมตีของผู้โจมตี
        defender.takeDamage(damage);    // ลด HP ของผู้ถูกโจมตี
        System.out.println(attacker.getClass().getSimpleName() + " โจมตี " +
                defender.getClass().getSimpleName() +
                " ด้วยพลังโจมตี: " + damage);
    }
}
