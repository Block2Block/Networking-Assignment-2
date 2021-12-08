package me.block2block.networks;

import me.block2block.networks.exceptions.DivideByZeroException;
import me.block2block.networks.exceptions.InvalidOperationException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class Mappings {

    @GetMapping(value = "/add/{x}/{y}", produces = MediaType.TEXT_PLAIN_VALUE)
    String add(@PathVariable int x, @PathVariable int y) {
        return (x + y) + "";
    }

    @GetMapping(value = "/subtract/{x}/{y}", produces = MediaType.TEXT_PLAIN_VALUE)
    String subtract(@PathVariable int x, @PathVariable int y) {
        return (x - y) + "";
    }

    @GetMapping(value = "/divide/{x}/{y}", produces = MediaType.TEXT_PLAIN_VALUE)
    String divide(@PathVariable int x, @PathVariable int y) {
        if (y == 0) {
            throw new DivideByZeroException();
        }
        return (x / y) + "";
    }

    @GetMapping(value = "/multiply/{x}/{y}", produces = MediaType.TEXT_PLAIN_VALUE)
    String multiply(@PathVariable int x, @PathVariable int y) {
        return (x * y) + "";
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String postMappings(@RequestBody PostRequest request) {
        JSONObject object = new JSONObject();
        if (request.getArguments().length < 2) {
            throw new IllegalArgumentException("Not enough arguments were provided.");
        }
        switch (request.getOperation().toLowerCase(Locale.ROOT)) {
            case "divide": {
                int value = request.getArguments()[0];
                for (int i = 1;i < request.getArguments().length;i++) {
                    if (request.getArguments()[i] == 0) {
                        throw new DivideByZeroException();
                    }
                    value = value / request.getArguments()[i];
                }
                try {
                    object.put("result", value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            case "multiply": {
                int value = request.getArguments()[0];
                for (int i = 1;i < request.getArguments().length;i++) {
                    value = value * request.getArguments()[i];
                }
                try {
                    object.put("result", value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "add": {
                int value = 0;
                for (int i : request.getArguments()) {
                    value += i;
                }
                try {
                    object.put("result", value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "subtract": {
                int value = 0;
                for (int i : request.getArguments()) {
                    value -= i;
                }
                try {
                    object.put("result", value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            }
            default: {
                throw new InvalidOperationException(request.getOperation());
            }
        }
        return object.toString(2);
    }

}
