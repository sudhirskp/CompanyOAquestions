package Epam_pool_drive_2026;

public class DeliveryRoute {
    Node head, tail;

    // Add urgent place (add first)
    public void addUrgentPlace(String address) {
        Node newNode = new Node(address);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add last
    public void addLast(String address) {
        Node newNode = new Node(address);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Cancel last
    public String cancelLast() {
        if (tail == null) return null;

        String val = tail.address;

        if (head == tail) {
            head = tail = null;
            return val;
        }

        tail = tail.prev;
        tail.next = null;

        return val;
    }

    // Deliver first
    public String deliverFirst() {
        if (head == null) return null;

        String val = head.address;

        if (head == tail) {
            head = tail = null;
            return val;
        }

        head = head.next;
        head.prev = null;

        return val;
    }

    // Peek first
    public String peekFirst() {
        return (head != null) ? head.address : null;
    }

    // Peek last
    public String peekLast() {
        return (tail != null) ? tail.address : null;
    }

    public static void main(String[] args) {
        DeliveryRoute ob = new DeliveryRoute();
        ob.addUrgentPlace("Delhi");
        ob.addUrgentPlace("Pune");
        ob.addUrgentPlace("Greater Noida");
        ob.addLast("Mumbai");
        System.out.println(ob.peekFirst());
        System.out.println(ob.peekLast());

        System.out.println(ob.deliverFirst());
        System.out.println(ob.cancelLast());
    }
}
