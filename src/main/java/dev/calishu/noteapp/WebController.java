package dev.calishu.noteapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.calishu.noteapp.db.Submit;
import dev.calishu.noteapp.db.Database;
import dev.calishu.noteapp.utils.Format;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class WebController {

    @Autowired
    private Submit submit;

    @GetMapping("/")
    public String getPage(Model model) {
        model.addAttribute("dataList", submit.getAllIds());
        return "index";
    }

    @PostMapping("/submit")
    public String submitInput(@RequestParam("inputText") String inputText, @RequestParam("timestamp") long timestamp, @RequestParam(value="entryId", required=false) Integer entryId, RedirectAttributes redirectAttributes) {
        if (entryId != null) {
            submit.updateData(entryId, inputText, (int)timestamp);
        } else 
            submit.submitData(inputText, (int)timestamp);
        return "redirect:/";
    }

    @GetMapping("/export")
    public void exportToCSV(HttpServletResponse response) throws IOException{
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=data.csv");

        PrintWriter writer = response.getWriter();
        writer.println("id,date,text");

        List<Database> dataList = submit.getAllIds();
        for (Database data : dataList) {
            writer.printf("%d,%s,\"%s\"%n", data.getId(), Format.unixTimestamp(data.getDate()), data.getText());
        }

        writer.flush();
        writer.close();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntry(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        submit.deleteData(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}