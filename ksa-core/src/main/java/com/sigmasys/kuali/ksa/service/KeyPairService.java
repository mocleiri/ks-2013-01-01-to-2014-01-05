package com.sigmasys.kuali.ksa.service;

import com.sigmasys.kuali.ksa.model.KeyPair;
import com.sigmasys.kuali.ksa.model.KeyPairAware;

import java.util.List;

/**
 * This interface defines basic operations on KeyPair objects.
 * KeyPairAware has to be persistent if there is a need to propagate changes to the persistent store.
 * <p/>
 *
 * @author Michael Ivanov
 */
public interface KeyPairService {

    /**
     * Adds new or merges existing key pairs of the given KeyPairAware instance.
     *
     * @param entity   KeyPairAware instance
     * @param keyPairs list of key pairs
     * @return KeyPairAware object
     */
    KeyPairAware addKeyPairs(KeyPairAware entity, List<KeyPair> keyPairs);

    /**
     * Adds new or merges existing key pairs of the given KeyPairAware instance.
     *
     * @param entity   KeyPairAware instance
     * @param keyPairs list of key pairs
     * @return KeyPairAware object
     */
    KeyPairAware addKeyPairs(KeyPairAware entity, KeyPair... keyPairs);

    /**
     * Removes key pairs specified by IDs from the given KeyPairAware instance.
     *
     * @param entity     KeyPairAware instance
     * @param keyPairIds list of key pair IDs
     * @return KeyPairAware object
     */
    KeyPairAware removeKeyPairs(KeyPairAware entity, List<Long> keyPairIds);

    /**
     * Removes key pairs specified by IDs from the given KeyPairAware instance.
     *
     * @param entity     KeyPairAware instance
     * @param keyPairIds list of key pair IDs
     * @return KeyPairAware object
     */
    KeyPairAware removeKeyPairs(KeyPairAware entity, Long... keyPairIds);

    /**
     * Removes key pairs specified by keys from the given KeyPairAware instance.
     *
     * @param entity KeyPairAware instance
     * @param keys   list of KeyPair keys
     * @return KeyPairAware object
     */
    KeyPairAware removeKeyPairsByKeys(KeyPairAware entity, List<String> keys);

    /**
     * Removes key pairs specified by keys from the given KeyPairAware instance.
     *
     * @param entity KeyPairAware instance
     * @param keys   list of KeyPair keys
     * @return KeyPairAware object
     */
    KeyPairAware removeKeyPairsByKeys(KeyPairAware entity, String... keys);

    /**
     * Updates a key pair specified by ID of the given KeyPairAware instance.
     * Throws IllegalArgumentException if no KeyPair is found.
     *
     * @param entity    KeyPairAware instance
     * @param keyPairId KeyPair ID
     * @param key       KeyPair key
     * @param value     KeyPair value
     * @return KeyPairAware object
     */
    KeyPairAware updateKeyPair(KeyPairAware entity, Long keyPairId, String key, String value);

}
