package steps;

import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import io.cucumber.datatable.TableTransformer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import model.datatable.Product;

public class DataTableConfigurer implements TypeRegistryConfigurer {

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry registry) {

		Transformer transformer = new Transformer();
		registry.setDefaultParameterTransformer(transformer);
		registry.setDefaultDataTableCellTransformer(transformer);
		registry.setDefaultDataTableEntryTransformer(transformer);

		/**
		 * Maps DataTable with label column to a single object of Type<T>. Left column
		 * is field name, right column is value. Needs @Transpose in stepdef parameter.
		 */
		registry.defineDataTableType(new DataTableType(Product.class, new TableTransformer<Product>() {
			@Override
			public Product transform(DataTable dataTable) {
				return new Product(dataTable.asMaps().get(0));
			}
		}));

	}

	private static final class Transformer
			implements ParameterByTypeTransformer, TableCellByTypeTransformer, TableEntryByTypeTransformer {

		private final ObjectMapper mapper = new ObjectMapper();

		@Override
		public Object transform(String fromValue, Type toValueType) {
			return mapper.convertValue(fromValue, mapper.constructType(toValueType));
		}

		@Override
		public <T> T transform(String value, Class<T> cellType) {
			return mapper.convertValue(value, cellType);
		}

		@Override
		public <T> T transform(Map<String, String> entry, Class<T> type, TableCellByTypeTransformer cellTransformer) {
			return mapper.convertValue(entry, type);
		}

	}

}
