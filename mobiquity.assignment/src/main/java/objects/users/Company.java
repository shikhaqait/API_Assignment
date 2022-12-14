
package objects.users;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "catchPhrase", "bs" })
public class Company {

	@JsonProperty("name")
	private String name;
	@JsonProperty("catchPhrase")
	private String catchPhrase;
	@JsonProperty("bs")
	private String bs;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public Company withName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("catchPhrase")
	public String getCatchPhrase() {
		return catchPhrase;
	}

	@JsonProperty("catchPhrase")
	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public Company withCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
		return this;
	}

	@JsonProperty("bs")
	public String getBs() {
		return bs;
	}

	@JsonProperty("bs")
	public void setBs(String bs) {
		this.bs = bs;
	}

	public Company withBs(String bs) {
		this.bs = bs;
		return this;
	}

}
