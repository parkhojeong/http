package hello.http.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @GetMapping("/members")
    public String members() {
        return "members";
    }

    @GetMapping("/members/{id}")
    public String member(@PathVariable Long id) {
        return "members/" + id;
    }

    @PostMapping("/members/create")
    public String createMember(MemberCreate create) {
        System.out.println("create = " + create);
        return "redirect:/members";
    }

    @Setter @Getter
    static public class MemberCreate {
        private String name;
    }

    @PatchMapping("/members/{id}")
    public String updateMember(@PathVariable Long id, @RequestBody MemberUpdate update) {
        System.out.println("id = " + id + ", update = " + update);
        return "redirect:/members/" + id;
    }

    @Setter @Getter
    static public class MemberUpdate {
        private String name;
    }

    @DeleteMapping("/members/{id}")
    public String deleteMember(@PathVariable Long id) {
        System.out.println("id = " + id);
        return "redirect:/members";
    }
}
