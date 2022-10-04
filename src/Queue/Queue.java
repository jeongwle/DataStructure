package Queue;

public interface Queue<E> {

    /**
     *
     * @param e Queue에 추가할 객체
     * @return 성공 시 true 실패 시 false
     * @throws IllegalStateException - capacity가 부족해서 추가하지 못할 경우
     */
    boolean add(E e);

    /**
     *
     * @return Queue에서 객체를 꺼내 반환
     * @throws java.util.NoSuchElementException - Queue가 비어 있을 경우
     */
    E remove();

    /**
     *
     * @return 삭제하지 않고 객체를 반환
     * @throws java.util.NoSuchElementException - Queue가 비어 있을 경우
     */
    E element();

    /**
     *
     * @param e - Queue에 추가할 객체
     * @return 성공 시 true 실패 시 false
     */
    boolean offer(E e);

    /**
     *
     * @return Queue에서 객체를 꺼내서 반환, 비어있을 경우 null을 반환
     */
    E poll();

    /**
     *
     * @return 삭제하지 않고 객체를 반환, 비어있을 경우 null을 반환
     */
    E peek();

}
