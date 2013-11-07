package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.model.KeyPair;
import com.sigmasys.kuali.ksa.model.KeyPairAware;
import com.sigmasys.kuali.ksa.service.KeyPairService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * KeyPairService implementation.
 *
 * @author Michael Ivanov
 */
@Service("keyPairService")
@Transactional
public class KeyPairServiceImpl extends GenericPersistenceService implements KeyPairService {


    private Set<KeyPair> mergeNewAndPersistentKeyPairs(List<KeyPair> keyPairsToAdd, Set<KeyPair> persistentKeyPairs) {

        // Persisting new or merging existing key pairs in the persistent store
        Set<Long> keyPairIds = new HashSet<Long>();
        for (KeyPair keyPair : keyPairsToAdd) {
            if (keyPair.getId() != null) {
                em.merge(keyPair);
                keyPairIds.add(keyPair.getId());
            } else {
                em.persist(keyPair);
            }
        }

        em.flush();

        if (CollectionUtils.isNotEmpty(persistentKeyPairs)) {
            for (KeyPair keyPair : new ArrayList<KeyPair>(persistentKeyPairs)) {
                if (keyPairIds.contains(keyPair.getId())) {
                    persistentKeyPairs.remove(keyPair);
                }
            }
        } else {
            persistentKeyPairs = new HashSet<KeyPair>(keyPairsToAdd.size());
        }

        persistentKeyPairs.addAll(keyPairsToAdd);

        return persistentKeyPairs;
    }

    private Set<KeyPair> removeKeyPairs(List<Long> keyPairIdsToRemove, Set<KeyPair> keyPairs) {

        Set<Long> keyPairIds = new HashSet<Long>(keyPairIdsToRemove);

        if (CollectionUtils.isNotEmpty(keyPairs)) {
            for (KeyPair keyPair : new ArrayList<KeyPair>(keyPairs)) {
                if (keyPairIds.contains(keyPair.getId())) {
                    keyPairs.remove(keyPair);
                    em.remove(keyPair);
                }
            }
            em.flush();
        }

        return keyPairs;
    }


    /**
     * Adds new or merges existing key pairs of the given KeyPairAware instance.
     *
     * @param entity   KeyPairAware instance
     * @param keyPairs list of key pairs
     * @return KeyPairAware object
     */
    @Override
    public KeyPairAware addKeyPairs(KeyPairAware entity, List<KeyPair> keyPairs) {
        Set<KeyPair> updatedKeyPairs = mergeNewAndPersistentKeyPairs(keyPairs, entity.getKeyPairs());
        entity.setKeyPairs(updatedKeyPairs);
        return entity;
    }

    /**
     * Adds new or merges existing key pairs of the given KeyPairAware instance.
     *
     * @param entity   KeyPairAware instance
     * @param keyPairs list of key pairs
     * @return KeyPairAware object
     */
    @Override
    public KeyPairAware addKeyPairs(KeyPairAware entity, KeyPair... keyPairs) {
        return addKeyPairs(entity, Arrays.asList(keyPairs));
    }

    /**
     * Removes key pairs specified by IDs from the given KeyPairAware instance.
     *
     * @param entity     KeyPairAware instance
     * @param keyPairIds list of key pair IDs
     * @return KeyPairAware object
     */
    @Override
    public KeyPairAware removeKeyPairs(KeyPairAware entity, List<Long> keyPairIds) {
        Set<KeyPair> updatedKeyPairs = removeKeyPairs(keyPairIds, entity.getKeyPairs());
        entity.setKeyPairs(updatedKeyPairs);
        return entity;
    }

    /**
     * Removes key pairs specified by IDs from the given KeyPairAware instance.
     *
     * @param entity     KeyPairAware instance
     * @param keyPairIds list of key pair IDs
     * @return KeyPairAware object
     */
    @Override
    public KeyPairAware removeKeyPairs(KeyPairAware entity, Long... keyPairIds) {
        return removeKeyPairs(entity, Arrays.asList(keyPairIds));
    }

    /**
     * Removes key pairs specified by keys from the given KeyPairAware instance.
     *
     * @param entity KeyPairAware instance
     * @param keys   list of KeyPair keys
     * @return KeyPairAware object
     */
    @Override
    public KeyPairAware removeKeyPairsByKeys(KeyPairAware entity, List<String> keys) {
        // TODO
        return entity;
    }

    /**
     * Removes key pairs specified by keys from the given KeyPairAware instance.
     *
     * @param entity KeyPairAware instance
     * @param keys   list of KeyPair keys
     * @return KeyPairAware object
     */
    @Override
    public KeyPairAware removeKeyPairsByKeys(KeyPairAware entity, String... keys) {
        // TODO
        return entity;
    }

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
    @Override
    public KeyPairAware updateKeyPair(KeyPairAware entity, Long keyPairId, String key, String value) {
        // TODO
        return entity;
    }

}
