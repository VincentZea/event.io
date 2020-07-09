package io.event.api.db;

public interface SupplierByKey<K, V> {

  V get(K key);
}
