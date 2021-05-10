package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private final static Map<Long, Item> store = new HashMap<>(); //실제는 HashMap X, Concurrent
    private static long sequence = 0L; //AtomicLong

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId() , item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long ItemId, Item updateParam){
        Item findItem = findById(ItemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}