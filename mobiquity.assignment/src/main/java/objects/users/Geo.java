
package objects.users;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "lat", "lng" })
public class Geo {

	@JsonProperty("lat")
	private String lat;
	@JsonProperty("lng")
	private String lng;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("lat")
	public String getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(String lat) {
		this.lat = lat;
	}

	public Geo withLat(String lat) {
		this.lat = lat;
		return this;
	}

	@JsonProperty("lng")
	public String getLng() {
		return lng;
	}

	@JsonProperty("lng")
	public void setLng(String lng) {
		this.lng = lng;
	}

	public Geo withLng(String lng) {
		this.lng = lng;
		return this;
	}

}
