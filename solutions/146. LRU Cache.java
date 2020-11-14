​
    // move the accessed node to the head;
    moveToHead(node);
​
    return node.value;
  }
​
  public void put(int key, int value) {
    DLinkedNode node = cache.get(key);
​
    if(node == null) {
      DLinkedNode newNode = new DLinkedNode();
      newNode.key = key;
      newNode.value = value;
​
      cache.put(key, newNode);
      addNode(newNode);
​
      ++size;
​
      if(size > capacity) {
        // pop the tail
        DLinkedNode tail = popTail();
        cache.remove(tail.key);
        --size;
      }
    } else {
      // update the value.
      node.value = value;
      moveToHead(node);
    }
  }
}
