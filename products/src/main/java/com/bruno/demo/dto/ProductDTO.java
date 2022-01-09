package com.bruno.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

public enum ProductDTO {;
	
	private interface Id {
		String getId();
	}

	private interface Name {
		String getName();
	}
	
	private interface Description {
		String getDescription();
	}
	
	private interface Price {
		double getPrice();
	}
	
	public enum Request {;
    	
    	@Data
        private static class Base implements Name, Description, Price {
    		private String name;
    		private String description;
    		private double price;
    		private Long vlPonto;
    	}
    	
    	public static class Cadastro extends Base {}       
        
    	@Data
    	@EqualsAndHashCode(callSuper = false)
        public static class Atualizacao extends Base implements Id {
        	private String id;
        }
	}
    	
}