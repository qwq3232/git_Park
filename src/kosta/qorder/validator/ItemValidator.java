package kosta.qorder.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kosta.qorder.service.ItemService;
import kosta.qorder.vo.Customer;
import kosta.qorder.vo.Item;

@Component
public class ItemValidator implements Validator
{
	@Autowired
	private ItemService service;
	@Override
	public boolean supports(Class<?> clazz)
	{
		return clazz.isAssignableFrom(Item.class);
	}

	@Override
	public void validate(Object target, Errors error)
	{
		Item item = (Item) target;
		Item findItem = service.getItemById(item.getItemId());
		
		if(findItem!=null)
		{
			error.rejectValue("itemId", "duplicate");
		}
		
		if(item.getItemName()==null||item.getItemName().trim().isEmpty()){
			error.rejectValue("itemName", "ItemNameRequired");
		}
		if(item.getItemDescription()==null||item.getItemDescription().trim().isEmpty()){
			error.rejectValue("itemDescription", "ItemDescriptionRequired");
		}
		if(item.getItemPrice() <= 0){
			error.rejectValue("itemPrice", "ItemPriceRequired");
		}
		if(item.getItemSort()==null||item.getItemSort().trim().isEmpty()){
			error.rejectValue("itemSort", "ItemSortRequired");
		}
	
		
		
	}
	
}
