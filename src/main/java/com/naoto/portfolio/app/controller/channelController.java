package com.naoto.portfolio.app.controller;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.naoto.portfolio.app.service.ChannelService;
import com.naoto.portfolio.domain.channels.model.Channel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller


public class channelController {

    private final ChannelService channelService;

    @PostMapping("/create")
    public String create(@Valid Channel channel,BindingResult result, Model model){
        if(result.hasErrors()){
            List<Channel> channels = channelService.findAll();
            model.addAttribute("channels", channels);
            model.addAttribute("channel", channel);
            return "channels/index";
        }
        channelService.create(channel);
        return "redirect:/channels";
    }

    @GetMapping("/channels")
    public String index(Model model) {
        List<Channel> channels = channelService.findAll();
        model.addAttribute("channels", channels);
        model.addAttribute("channel", new Channel());
        return "channels/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Optional<Channel> channel = channelService.findById(id);
        model.addAttribute("channel", channel);
        return "channels/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id,@Validated @ModelAttribute Channel channel, BindingResult result) {
        if(result.hasErrors()){
            return "channels/edit";
        }
        channelService.update(channel);
        return "redirect:/channels";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        channelService.delete(id);
        return "redirect:/channels";
    }
    
}
