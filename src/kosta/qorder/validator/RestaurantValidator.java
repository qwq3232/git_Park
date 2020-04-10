package kosta.qorder.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kosta.qorder.service.CustomerService;
import kosta.qorder.service.RestaurantService;
import kosta.qorder.vo.Customer;
import kosta.qorder.vo.Restaurant;

@Component
public class RestaurantValidator implements Validator
{
	@Autowired
	private RestaurantService service;

	@Override
	public boolean supports(Class<?> clazz)
	{
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Restaurant.class);
	}

	@Override
	public void validate(Object target, Errors error)
	{
		Restaurant res = (Restaurant) target;

		Restaurant findRes = service.getRestaurantById(res.getRestaurantId());

		

		if (findRes!=null)
		{
			error.rejectValue("restaurantId", "duplicate","중복됬습니다.");
		}

		if (res.getRestaurantName() == null
				|| res.getRestaurantName().trim().isEmpty())
		{
			error.rejectValue("restaurantName", "restaurantNameRequired","이름이 잘못됬습니다.");
		}
		if (res.getRestaurantDescription() == null
				|| res.getRestaurantDescription().trim().isEmpty())
		{
			error.rejectValue("restaurantDescription",
					"restaurantDescriptionRequired","설명입력이 안됬습니다.");
		}
		if (res.getRestaurantPhone() == null
				|| res.getRestaurantPhone().trim().isEmpty())
		{
			error.rejectValue("restaurantPhone", "restaurantPhoneRequired");
		}
		if (res.getRestaurantAddress() == null
				|| res.getRestaurantAddress().trim().isEmpty())
		{
			error.rejectValue("restaurantAddress", "restaurantAddressRequired","주소를 입력해주세요");
		}

		if (res.getOwnerId() == null || res.getOwnerId().trim().isEmpty())
		{
			error.rejectValue("ownerId", "ownerIdRequired","손님아이드를 입력해주세요");

		}

	}

	
}
